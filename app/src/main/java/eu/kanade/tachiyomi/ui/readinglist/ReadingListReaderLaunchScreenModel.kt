package eu.kanade.tachiyomi.ui.readinglist

import androidx.compose.runtime.Immutable
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tachiyomi.core.common.util.lang.withIOContext
import tachiyomi.domain.readinglist.model.ReadingListSummary

class ReadingListReaderLaunchScreenModel(
    private val readerNavigator: ReadingListReaderNavigator = ReadingListReaderNavigator(),
) : StateScreenModel<ReadingListReaderLaunchState>(ReadingListReaderLaunchState()) {

    private val _events = Channel<ReadingListReaderLaunchEvent>()
    val events = _events.receiveAsFlow()

    fun start(readingList: ReadingListSummary) {
        if (state.value.isLoading) return
        if (readingList.completed) {
            mutableState.update {
                it.copy(dialog = ReadingListReaderLaunchDialog.Restart(readingList))
            }
            return
        }
        open(readingList.id, restartCompleted = false)
    }

    fun confirmRestart() {
        val dialog = state.value.dialog as? ReadingListReaderLaunchDialog.Restart ?: return
        mutableState.update { it.copy(dialog = null) }
        open(dialog.readingList.id, restartCompleted = true)
    }

    fun skipBlocked() {
        val blocked = (state.value.dialog as? ReadingListReaderLaunchDialog.Blocked)?.entry ?: return
        if (state.value.isLoading) return
        mutableState.update { it.copy(isLoading = true, dialog = null) }
        screenModelScope.launch {
            try {
                handleResult(
                    withIOContext {
                        readerNavigator.skip(blocked.readingListId, blocked.entryId)
                    },
                )
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                _events.send(ReadingListReaderLaunchEvent.Failed)
            } finally {
                mutableState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun reviewBlocked() {
        val blocked = (state.value.dialog as? ReadingListReaderLaunchDialog.Blocked)?.entry ?: return
        mutableState.update { it.copy(dialog = null) }
        screenModelScope.launch {
            _events.send(ReadingListReaderLaunchEvent.Review(blocked.readingListId))
        }
    }

    fun dismissDialog() {
        if (state.value.isLoading) return
        mutableState.update { it.copy(dialog = null) }
    }

    private fun open(readingListId: Long, restartCompleted: Boolean) {
        if (state.value.isLoading) return
        mutableState.update { it.copy(isLoading = true) }
        screenModelScope.launch {
            try {
                handleResult(
                    withIOContext {
                        readerNavigator.start(readingListId, restartCompleted)
                    },
                )
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                _events.send(ReadingListReaderLaunchEvent.Failed)
            } finally {
                mutableState.update { it.copy(isLoading = false) }
            }
        }
    }

    private suspend fun handleResult(result: ReadingListReaderResult) {
        when (result) {
            is ReadingListReaderResult.Ready -> {
                mutableState.update { it.copy(dialog = null) }
                _events.send(ReadingListReaderLaunchEvent.OpenReader(result.destination))
            }
            is ReadingListReaderResult.Blocked -> {
                mutableState.update {
                    it.copy(dialog = ReadingListReaderLaunchDialog.Blocked(result.entry))
                }
            }
            is ReadingListReaderResult.Completed -> {
                mutableState.update { it.copy(dialog = null) }
                _events.send(
                    ReadingListReaderLaunchEvent.Completed(
                        readingListId = result.readingListId,
                        readingListName = result.readingListName,
                    ),
                )
            }
            is ReadingListReaderResult.MissingReadingList,
            is ReadingListReaderResult.MissingEntry,
            is ReadingListReaderResult.MissingEntryAtPosition,
            is ReadingListReaderResult.Boundary,
            -> _events.send(ReadingListReaderLaunchEvent.Failed)
        }
    }
}

@Immutable
data class ReadingListReaderLaunchState(
    val isLoading: Boolean = false,
    val dialog: ReadingListReaderLaunchDialog? = null,
)

sealed interface ReadingListReaderLaunchDialog {
    data class Restart(val readingList: ReadingListSummary) : ReadingListReaderLaunchDialog
    data class Blocked(val entry: ReadingListReaderBlockedEntry) : ReadingListReaderLaunchDialog
}

sealed interface ReadingListReaderLaunchEvent {
    data class OpenReader(val destination: ReadingListReaderDestination) : ReadingListReaderLaunchEvent
    data class Review(val readingListId: Long) : ReadingListReaderLaunchEvent
    data class Completed(
        val readingListId: Long,
        val readingListName: String?,
    ) : ReadingListReaderLaunchEvent
    data object Failed : ReadingListReaderLaunchEvent
}
