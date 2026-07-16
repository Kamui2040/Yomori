package eu.kanade.tachiyomi.ui.reader

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.ui.main.MainActivity
import eu.kanade.tachiyomi.ui.reader.model.ViewerChapters
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderBlockedDialog
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderBlockedEntry
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderDestination
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderDirection
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderNavigator
import eu.kanade.tachiyomi.ui.readinglist.ReadingListReaderResult
import eu.kanade.tachiyomi.util.system.toast
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import tachiyomi.core.common.util.lang.withIOContext

/**
 * Runs one exact reading-list entry in the normal reader while keeping list navigation separate from
 * the manga's ordinary chapter order.
 */
class ReadingListReaderActivity : ReaderActivity() {

    private val readingListNavigator by lazy { ReadingListReaderNavigator() }

    private var destination: ReadingListReaderDestination? = null
    private var blockedEntry by mutableStateOf<ReadingListReaderBlockedEntry?>(null)
    private var isNavigating by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        destination = intent.toReadingListDestination()
        super.onCreate(savedInstanceState)
        if (destination == null) {
            finish()
        }
    }

    override fun setChapters(viewerChapters: ViewerChapters) {
        super.setChapters(
            ViewerChapters(
                currChapter = viewerChapters.currChapter,
                prevChapter = null,
                nextChapter = null,
            ),
        )
    }

    override fun canLoadPreviousChapter(): Boolean = destination?.hasPrevious == true

    override fun canLoadNextChapter(): Boolean = destination?.hasNext == true

    override fun readerChapterTitle(): String? {
        val current = destination ?: return super.readerChapterTitle()
        val position = getString(
            R.string.reading_list_reader_position,
            current.position + 1,
            current.entryCount,
        )
        return super.readerChapterTitle()?.let { chapterTitle -> "$position • $chapterTitle" } ?: position
    }

    override fun loadNextChapter() {
        move(ReadingListReaderDirection.NEXT)
    }

    override fun loadPreviousChapter() {
        move(ReadingListReaderDirection.PREVIOUS)
    }

    override fun onChapterBoundary(boundary: ReaderChapterBoundary) {
        move(
            when (boundary) {
                ReaderChapterBoundary.PREVIOUS -> ReadingListReaderDirection.PREVIOUS
                ReaderChapterBoundary.NEXT -> ReadingListReaderDirection.NEXT
            },
        )
    }

    @Composable
    override fun AdditionalReaderContent() {
        blockedEntry?.let { entry ->
            ReadingListReaderBlockedDialog(
                entry = entry,
                onReview = ::reviewBlockedEntry,
                onSkip = ::skipBlockedEntry,
                onStop = ::stopAtBlockedEntry,
            )
        }
    }

    private fun move(direction: ReadingListReaderDirection) {
        val current = destination ?: return
        if (isNavigating || blockedEntry != null) return
        isNavigating = true
        viewModel.showLoadingDialog()
        lifecycleScope.launch {
            try {
                handleResult(
                    withIOContext {
                        readingListNavigator.move(
                            readingListId = current.readingListId,
                            currentEntryId = current.entryId,
                            direction = direction,
                        )
                    },
                )
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                viewModel.closeDialog()
                toast(R.string.reading_list_reader_failed)
            } finally {
                isNavigating = false
            }
        }
    }

    private fun skipBlockedEntry() {
        val blocked = blockedEntry ?: return
        if (isNavigating) return
        isNavigating = true
        blockedEntry = null
        viewModel.showLoadingDialog()
        lifecycleScope.launch {
            try {
                handleResult(
                    withIOContext {
                        readingListNavigator.skip(
                            readingListId = blocked.readingListId,
                            blockedEntryId = blocked.entryId,
                        )
                    },
                )
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                viewModel.closeDialog()
                toast(R.string.reading_list_reader_failed)
            } finally {
                isNavigating = false
            }
        }
    }

    private fun reviewBlockedEntry() {
        val blocked = blockedEntry ?: return
        blockedEntry = null
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                action = ACTION_REVIEW_READING_LIST
                putExtra(EXTRA_READING_LIST_ID, blocked.readingListId)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            },
        )
        finish()
    }

    private fun stopAtBlockedEntry() {
        blockedEntry = null
        finish()
    }

    private fun handleResult(result: ReadingListReaderResult) {
        when (result) {
            is ReadingListReaderResult.Ready -> {
                viewModel.closeDialog()
                startActivity(newIntent(this, result.destination))
                finish()
            }
            is ReadingListReaderResult.Blocked -> {
                viewModel.closeDialog()
                blockedEntry = result.entry
            }
            is ReadingListReaderResult.Completed -> {
                viewModel.closeDialog()
                toast(
                    getString(
                        R.string.reading_list_reader_completed,
                        result.readingListName ?: getString(R.string.reading_list_untitled),
                    ),
                )
                finish()
            }
            is ReadingListReaderResult.Boundary -> {
                viewModel.closeDialog()
                if (result.direction == ReadingListReaderDirection.NEXT) {
                    showMenu()
                }
            }
            is ReadingListReaderResult.MissingReadingList,
            is ReadingListReaderResult.MissingEntry,
            is ReadingListReaderResult.MissingEntryAtPosition,
            -> {
                viewModel.closeDialog()
                toast(R.string.reading_list_reader_failed)
            }
        }
    }

    private fun Intent.toReadingListDestination(): ReadingListReaderDestination? {
        val readingListId = getLongExtra(EXTRA_READING_LIST_ID, -1L)
        val entryId = getLongExtra(EXTRA_ENTRY_ID, -1L)
        val position = getIntExtra(EXTRA_POSITION, -1)
        val entryCount = getIntExtra(EXTRA_ENTRY_COUNT, -1)
        val mangaId = getLongExtra(EXTRA_MANGA_ID, -1L)
        val chapterId = getLongExtra(EXTRA_CHAPTER_ID, -1L)
        if (
            readingListId < 0L ||
            entryId < 0L ||
            position < 0 ||
            entryCount <= 0 ||
            position >= entryCount ||
            mangaId < 0L ||
            chapterId < 0L
        ) {
            return null
        }
        return ReadingListReaderDestination(
            readingListId = readingListId,
            readingListName = getStringExtra(EXTRA_READING_LIST_NAME),
            entryId = entryId,
            position = position,
            entryCount = entryCount,
            mangaId = mangaId,
            chapterId = chapterId,
            hasPrevious = getBooleanExtra(EXTRA_HAS_PREVIOUS, false),
            hasNext = getBooleanExtra(EXTRA_HAS_NEXT, false),
        )
    }

    companion object {
        const val ACTION_REVIEW_READING_LIST = "io.github.kamui2040.yomori.REVIEW_READING_LIST"
        const val EXTRA_READING_LIST_ID = "reading_list_id"

        private const val EXTRA_READING_LIST_NAME = "reading_list_name"
        private const val EXTRA_ENTRY_ID = "reading_list_entry_id"
        private const val EXTRA_POSITION = "reading_list_position"
        private const val EXTRA_ENTRY_COUNT = "reading_list_entry_count"
        private const val EXTRA_MANGA_ID = "manga"
        private const val EXTRA_CHAPTER_ID = "chapter"
        private const val EXTRA_HAS_PREVIOUS = "reading_list_has_previous"
        private const val EXTRA_HAS_NEXT = "reading_list_has_next"

        fun newIntent(
            context: Context,
            destination: ReadingListReaderDestination,
        ): Intent {
            return Intent(context, ReadingListReaderActivity::class.java).apply {
                putExtra(EXTRA_READING_LIST_ID, destination.readingListId)
                putExtra(EXTRA_READING_LIST_NAME, destination.readingListName)
                putExtra(EXTRA_ENTRY_ID, destination.entryId)
                putExtra(EXTRA_POSITION, destination.position)
                putExtra(EXTRA_ENTRY_COUNT, destination.entryCount)
                putExtra(EXTRA_MANGA_ID, destination.mangaId)
                putExtra(EXTRA_CHAPTER_ID, destination.chapterId)
                putExtra(EXTRA_HAS_PREVIOUS, destination.hasPrevious)
                putExtra(EXTRA_HAS_NEXT, destination.hasNext)
            }
        }
    }
}
