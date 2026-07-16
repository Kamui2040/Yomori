package eu.kanade.tachiyomi.ui.readinglist

import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.source.online.HttpSource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withTimeout
import tachiyomi.domain.chapter.model.Chapter
import tachiyomi.domain.chapter.repository.ChapterRepository
import tachiyomi.domain.manga.model.Manga
import tachiyomi.domain.manga.repository.MangaRepository
import tachiyomi.domain.readinglist.model.ReadingList
import tachiyomi.domain.readinglist.model.ReadingListEntry
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.repository.ReadingListRepository
import tachiyomi.domain.source.service.SourceManager
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

class ReadingListReaderNavigator(
    private val readingListRepository: ReadingListRepository = Injekt.get(),
    private val mangaRepository: MangaRepository = Injekt.get(),
    private val chapterRepository: ChapterRepository = Injekt.get(),
    private val sourceManager: SourceManager = Injekt.get(),
    private val requestTimeoutMillis: Long = DEFAULT_REQUEST_TIMEOUT_MILLIS,
) {

    suspend fun start(
        readingListId: Long,
        restartCompleted: Boolean = false,
    ): ReadingListReaderResult {
        val readingList = readingListRepository.get(readingListId)
            ?: return ReadingListReaderResult.MissingReadingList(readingListId)
        if (readingList.entries.isEmpty()) {
            val saved = readingListRepository.updateProgress(
                id = readingList.id,
                currentPosition = null,
                completed = true,
            )
            return if (saved) {
                ReadingListReaderResult.Completed(readingList.id, readingList.name)
            } else {
                ReadingListReaderResult.MissingReadingList(readingList.id)
            }
        }
        if (readingList.completed && !restartCompleted) {
            return ReadingListReaderResult.Completed(readingList.id, readingList.name)
        }

        val position = if (restartCompleted) {
            0
        } else {
            readingList.currentPosition ?: 0
        }
        return openPosition(readingList, position)
    }

    suspend fun move(
        readingListId: Long,
        currentEntryId: Long,
        direction: ReadingListReaderDirection,
    ): ReadingListReaderResult {
        val readingList = readingListRepository.get(readingListId)
            ?: return ReadingListReaderResult.MissingReadingList(readingListId)
        val orderedEntries = readingList.entries.sortedBy(ReadingListEntry::position)
        val currentIndex = orderedEntries.indexOfFirst { entry -> entry.id == currentEntryId }
        if (currentIndex < 0) {
            return ReadingListReaderResult.MissingEntry(readingList.id, currentEntryId)
        }

        val targetIndex = when (direction) {
            ReadingListReaderDirection.PREVIOUS -> currentIndex - 1
            ReadingListReaderDirection.NEXT -> currentIndex + 1
        }
        if (targetIndex < 0) {
            return ReadingListReaderResult.Boundary(
                readingListId = readingList.id,
                direction = direction,
            )
        }
        if (targetIndex >= orderedEntries.size) {
            val saved = readingListRepository.updateProgress(
                id = readingList.id,
                currentPosition = null,
                completed = true,
            )
            return if (saved) {
                ReadingListReaderResult.Completed(readingList.id, readingList.name)
            } else {
                ReadingListReaderResult.MissingReadingList(readingList.id)
            }
        }
        return openPosition(readingList, targetIndex)
    }

    suspend fun skip(
        readingListId: Long,
        blockedEntryId: Long,
    ): ReadingListReaderResult {
        val readingList = readingListRepository.get(readingListId)
            ?: return ReadingListReaderResult.MissingReadingList(readingListId)
        val orderedEntries = readingList.entries.sortedBy(ReadingListEntry::position)
        val blockedIndex = orderedEntries.indexOfFirst { entry -> entry.id == blockedEntryId }
        if (blockedIndex < 0) {
            return ReadingListReaderResult.MissingEntry(readingList.id, blockedEntryId)
        }
        if (!readingListRepository.setEntrySkipped(readingList.id, blockedEntryId, skipped = true)) {
            return ReadingListReaderResult.MissingEntry(readingList.id, blockedEntryId)
        }

        val targetIndex = blockedIndex + 1
        if (targetIndex >= orderedEntries.size) {
            val saved = readingListRepository.updateProgress(
                id = readingList.id,
                currentPosition = null,
                completed = true,
            )
            return if (saved) {
                ReadingListReaderResult.Completed(readingList.id, readingList.name)
            } else {
                ReadingListReaderResult.MissingReadingList(readingList.id)
            }
        }
        val refreshed = readingListRepository.get(readingList.id)
            ?: return ReadingListReaderResult.MissingReadingList(readingList.id)
        return openPosition(refreshed, targetIndex)
    }

    private suspend fun openPosition(
        readingList: ReadingList,
        index: Int,
    ): ReadingListReaderResult {
        val orderedEntries = readingList.entries.sortedBy(ReadingListEntry::position)
        val entry = orderedEntries.getOrNull(index)
            ?: return ReadingListReaderResult.MissingEntryAtPosition(readingList.id, index)
        if (entry.position != index) {
            return ReadingListReaderResult.MissingEntryAtPosition(readingList.id, index)
        }
        if (
            !readingListRepository.updateProgress(
                id = readingList.id,
                currentPosition = entry.position,
                completed = false,
            )
        ) {
            return ReadingListReaderResult.MissingReadingList(readingList.id)
        }

        entry.blockingReason()?.let { reason ->
            return ReadingListReaderResult.Blocked(entry.toBlocked(readingList, reason))
        }

        val sourceId = entry.matchedSourceId
            ?: return ReadingListReaderResult.Blocked(
                entry.toBlocked(readingList, ReadingListReaderBlockReason.MISSING_MATCH_IDENTITY),
            )
        val mangaUrl = entry.matchedMangaUrl
            ?: return ReadingListReaderResult.Blocked(
                entry.toBlocked(readingList, ReadingListReaderBlockReason.MISSING_MATCH_IDENTITY),
            )
        val chapterUrl = entry.matchedChapterUrl
            ?: return ReadingListReaderResult.Blocked(
                entry.toBlocked(readingList, ReadingListReaderBlockReason.MISSING_MATCH_IDENTITY),
            )
        if (sourceId !in readingList.selectedSourceIds) {
            readingListRepository.markEntryReaderFailure(
                entry.id,
                ReadingListEntryResolutionState.NEEDS_REMATCH,
            )
            return ReadingListReaderResult.Blocked(
                entry.toBlocked(readingList, ReadingListReaderBlockReason.SOURCE_NOT_SELECTED),
            )
        }

        sourceManager.isInitialized.first { initialized -> initialized }
        val source = sourceManager.get(sourceId) as? HttpSource
        if (source == null) {
            readingListRepository.markEntryReaderFailure(
                entry.id,
                ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            )
            return ReadingListReaderResult.Blocked(
                entry.toBlocked(readingList, ReadingListReaderBlockReason.SOURCE_UNAVAILABLE),
            )
        }

        return when (
            val materialized = materialize(
                entry = entry,
                source = source,
                mangaUrl = mangaUrl,
                chapterUrl = chapterUrl,
            )
        ) {
            is MaterializationResult.Ready -> {
                readingListRepository.clearEntryReaderFailure(entry.id)
                ReadingListReaderResult.Ready(
                    ReadingListReaderDestination(
                        readingListId = readingList.id,
                        readingListName = readingList.name,
                        entryId = entry.id,
                        position = entry.position,
                        entryCount = orderedEntries.size,
                        mangaId = materialized.manga.id,
                        chapterId = materialized.chapter.id,
                        hasPrevious = entry.position > 0,
                        hasNext = entry.position < orderedEntries.lastIndex,
                    ),
                )
            }
            MaterializationResult.ChapterMissing -> {
                readingListRepository.markEntryReaderFailure(
                    entry.id,
                    ReadingListEntryResolutionState.CHAPTER_REMOVED,
                )
                ReadingListReaderResult.Blocked(
                    entry.toBlocked(readingList, ReadingListReaderBlockReason.CHAPTER_REMOVED),
                )
            }
            MaterializationResult.SourceFailure -> {
                readingListRepository.markEntryReaderFailure(
                    entry.id,
                    ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
                )
                ReadingListReaderResult.Blocked(
                    entry.toBlocked(readingList, ReadingListReaderBlockReason.SOURCE_REQUEST_FAILED),
                )
            }
            MaterializationResult.PersistenceFailure -> {
                readingListRepository.markEntryReaderFailure(
                    entry.id,
                    ReadingListEntryResolutionState.NEEDS_REMATCH,
                )
                ReadingListReaderResult.Blocked(
                    entry.toBlocked(readingList, ReadingListReaderBlockReason.MATERIALIZATION_FAILED),
                )
            }
        }
    }

    private suspend fun materialize(
        entry: ReadingListEntry,
        source: HttpSource,
        mangaUrl: String,
        chapterUrl: String,
    ): MaterializationResult {
        val existingManga = mangaRepository.getMangaByUrlAndSourceId(mangaUrl, source.id)
        if (existingManga != null) {
            val existingChapter = chapterRepository.getChapterByUrlAndMangaId(chapterUrl, existingManga.id)
            if (existingChapter != null) {
                return MaterializationResult.Ready(existingManga, existingChapter)
            }
        }

        val update = try {
            requestSemaphore.withPermit {
                withTimeout(requestTimeoutMillis) {
                    source.getMangaUpdate(
                        manga = SManga.create().apply {
                            url = mangaUrl
                            title = entry.series
                        },
                        chapters = emptyList(),
                        fetchDetails = true,
                        fetchChapters = true,
                    )
                }
            }
        } catch (_: TimeoutCancellationException) {
            return MaterializationResult.SourceFailure
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            return MaterializationResult.SourceFailure
        }

        val remoteChapter = update.chapters.firstOrNull { chapter -> chapter.url == chapterUrl }
            ?: return MaterializationResult.ChapterMissing
        val manga = existingManga ?: insertManga(source.id, mangaUrl, entry, update.manga)
            ?: mangaRepository.getMangaByUrlAndSourceId(mangaUrl, source.id)
            ?: return MaterializationResult.PersistenceFailure
        val existingChapter = chapterRepository.getChapterByUrlAndMangaId(chapterUrl, manga.id)
        if (existingChapter != null) {
            return MaterializationResult.Ready(manga, existingChapter)
        }
        val chapter = insertChapter(manga.id, chapterUrl, remoteChapter)
            ?: chapterRepository.getChapterByUrlAndMangaId(chapterUrl, manga.id)
            ?: return MaterializationResult.PersistenceFailure
        return MaterializationResult.Ready(manga, chapter)
    }

    private suspend fun insertManga(
        sourceId: Long,
        mangaUrl: String,
        entry: ReadingListEntry,
        remote: SManga,
    ): Manga? {
        val manga = Manga.create().copy(
            source = sourceId,
            url = mangaUrl,
            title = remote.title.ifBlank { entry.series },
            artist = remote.artist,
            author = remote.author,
            description = remote.description,
            genre = remote.getGenres(),
            status = remote.status.toLong(),
            thumbnailUrl = remote.thumbnail_url,
            updateStrategy = remote.update_strategy,
            initialized = remote.initialized,
            favorite = false,
            memo = remote.memo,
        )
        return mangaRepository.insertNetworkManga(listOf(manga)).firstOrNull()
    }

    private suspend fun insertChapter(
        mangaId: Long,
        chapterUrl: String,
        remote: SChapter,
    ): Chapter? {
        val chapter = Chapter.create().copy(
            mangaId = mangaId,
            url = chapterUrl,
            name = remote.name.ifBlank { chapterUrl },
            chapterNumber = remote.chapter_number.toDouble(),
            scanlator = remote.scanlator,
            dateUpload = remote.date_upload,
            sourceOrder = 0,
            dateFetch = System.currentTimeMillis(),
            memo = remote.memo,
        )
        return chapterRepository.addAll(listOf(chapter)).firstOrNull()
    }

    private fun ReadingListEntry.blockingReason(): ReadingListReaderBlockReason? {
        if (skipped) return ReadingListReaderBlockReason.SKIPPED
        return when (resolutionState) {
            ReadingListEntryResolutionState.AUTO_MATCHED,
            ReadingListEntryResolutionState.USER_CONFIRMED,
            -> null
            ReadingListEntryResolutionState.UNSEARCHED -> ReadingListReaderBlockReason.UNSEARCHED
            ReadingListEntryResolutionState.SEARCHING -> ReadingListReaderBlockReason.SEARCHING
            ReadingListEntryResolutionState.AMBIGUOUS -> ReadingListReaderBlockReason.AMBIGUOUS
            ReadingListEntryResolutionState.UNRESOLVED -> ReadingListReaderBlockReason.UNRESOLVED
            ReadingListEntryResolutionState.SOURCE_UNAVAILABLE -> ReadingListReaderBlockReason.SOURCE_UNAVAILABLE
            ReadingListEntryResolutionState.CHAPTER_REMOVED -> ReadingListReaderBlockReason.CHAPTER_REMOVED
            ReadingListEntryResolutionState.NEEDS_REMATCH -> ReadingListReaderBlockReason.NEEDS_REMATCH
        }
    }

    private fun ReadingListEntry.toBlocked(
        readingList: ReadingList,
        reason: ReadingListReaderBlockReason,
    ): ReadingListReaderBlockedEntry {
        return ReadingListReaderBlockedEntry(
            readingListId = readingList.id,
            readingListName = readingList.name,
            entryId = id,
            position = position,
            entryCount = readingList.entries.size,
            series = series,
            issueNumber = number,
            reason = reason,
        )
    }

    private sealed interface MaterializationResult {
        data class Ready(
            val manga: Manga,
            val chapter: Chapter,
        ) : MaterializationResult

        data object ChapterMissing : MaterializationResult
        data object SourceFailure : MaterializationResult
        data object PersistenceFailure : MaterializationResult
    }

    private companion object {
        val requestSemaphore = Semaphore(2)
        const val DEFAULT_REQUEST_TIMEOUT_MILLIS = 30_000L
    }
}

enum class ReadingListReaderDirection {
    PREVIOUS,
    NEXT,
}

enum class ReadingListReaderBlockReason {
    UNSEARCHED,
    SEARCHING,
    AMBIGUOUS,
    UNRESOLVED,
    SOURCE_UNAVAILABLE,
    CHAPTER_REMOVED,
    NEEDS_REMATCH,
    SKIPPED,
    MISSING_MATCH_IDENTITY,
    SOURCE_NOT_SELECTED,
    SOURCE_REQUEST_FAILED,
    MATERIALIZATION_FAILED,
}

data class ReadingListReaderDestination(
    val readingListId: Long,
    val readingListName: String?,
    val entryId: Long,
    val position: Int,
    val entryCount: Int,
    val mangaId: Long,
    val chapterId: Long,
    val hasPrevious: Boolean,
    val hasNext: Boolean,
)

data class ReadingListReaderBlockedEntry(
    val readingListId: Long,
    val readingListName: String?,
    val entryId: Long,
    val position: Int,
    val entryCount: Int,
    val series: String,
    val issueNumber: String,
    val reason: ReadingListReaderBlockReason,
)

sealed interface ReadingListReaderResult {
    data class Ready(val destination: ReadingListReaderDestination) : ReadingListReaderResult
    data class Blocked(val entry: ReadingListReaderBlockedEntry) : ReadingListReaderResult
    data class Completed(val readingListId: Long, val readingListName: String?) : ReadingListReaderResult
    data class Boundary(
        val readingListId: Long,
        val direction: ReadingListReaderDirection,
    ) : ReadingListReaderResult

    data class MissingReadingList(val readingListId: Long) : ReadingListReaderResult
    data class MissingEntry(val readingListId: Long, val entryId: Long) : ReadingListReaderResult
    data class MissingEntryAtPosition(val readingListId: Long, val position: Int) : ReadingListReaderResult
}
