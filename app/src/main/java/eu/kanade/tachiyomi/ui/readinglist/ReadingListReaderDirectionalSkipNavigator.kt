package eu.kanade.tachiyomi.ui.readinglist

import tachiyomi.domain.readinglist.repository.ReadingListRepository
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Applies an explicit reader skip in the direction that reached the blocked entry.
 */
internal class ReadingListReaderDirectionalSkipNavigator(
    private val readingListRepository: ReadingListRepository = Injekt.get(),
    private val readerNavigator: ReadingListReaderNavigator = ReadingListReaderNavigator(),
) {

    suspend fun skip(
        readingListId: Long,
        blockedEntryId: Long,
        direction: ReadingListReaderDirection,
    ): ReadingListReaderResult {
        if (direction == ReadingListReaderDirection.NEXT) {
            return readerNavigator.skip(readingListId, blockedEntryId)
        }

        val readingList = readingListRepository.get(readingListId)
            ?: return ReadingListReaderResult.MissingReadingList(readingListId)
        if (readingList.entries.none { entry -> entry.id == blockedEntryId }) {
            return ReadingListReaderResult.MissingEntry(readingListId, blockedEntryId)
        }
        if (!readingListRepository.setEntrySkipped(readingListId, blockedEntryId, skipped = true)) {
            return ReadingListReaderResult.MissingEntry(readingListId, blockedEntryId)
        }

        return readerNavigator.move(
            readingListId = readingListId,
            currentEntryId = blockedEntryId,
            direction = ReadingListReaderDirection.PREVIOUS,
        )
    }
}
