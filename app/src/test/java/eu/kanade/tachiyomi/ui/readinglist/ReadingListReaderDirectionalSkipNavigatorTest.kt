package eu.kanade.tachiyomi.ui.readinglist

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import tachiyomi.domain.readinglist.model.ReadingList
import tachiyomi.domain.readinglist.model.ReadingListEntry
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.repository.ReadingListRepository

class ReadingListReaderDirectionalSkipNavigatorTest {

    @Test
    fun `forward skip keeps the existing forward behavior`() = runTest {
        val repository = mockk<ReadingListRepository>()
        val navigator = mockk<ReadingListReaderNavigator>()
        val expected = ReadingListReaderResult.Boundary(
            readingListId = READING_LIST_ID,
            direction = ReadingListReaderDirection.NEXT,
        )
        coEvery { navigator.skip(READING_LIST_ID, BLOCKED_ENTRY_ID) } returns expected
        val subject = ReadingListReaderDirectionalSkipNavigator(repository, navigator)

        subject.skip(
            readingListId = READING_LIST_ID,
            blockedEntryId = BLOCKED_ENTRY_ID,
            direction = ReadingListReaderDirection.NEXT,
        ) shouldBe expected

        coVerify(exactly = 1) { navigator.skip(READING_LIST_ID, BLOCKED_ENTRY_ID) }
        coVerify(exactly = 0) { repository.get(any()) }
    }

    @Test
    fun `backward skip marks only the blocked entry and opens the previous entry at its end`() = runTest {
        val repository = mockk<ReadingListRepository>()
        val navigator = mockk<ReadingListReaderNavigator>()
        val readingList = readingList(entries = listOf(entry(BLOCKED_ENTRY_ID, position = 1)))
        val expected = ReadingListReaderResult.Ready(
            ReadingListReaderDestination(
                readingListId = READING_LIST_ID,
                readingListName = "Fixture",
                entryId = PREVIOUS_ENTRY_ID,
                position = 0,
                entryCount = 2,
                mangaId = 100L,
                chapterId = 200L,
                hasPrevious = false,
                hasNext = true,
                openAtEnd = true,
                resumePage = null,
            ),
        )
        coEvery { repository.get(READING_LIST_ID) } returns readingList
        coEvery {
            repository.setEntrySkipped(READING_LIST_ID, BLOCKED_ENTRY_ID, skipped = true)
        } returns true
        coEvery {
            navigator.move(
                READING_LIST_ID,
                BLOCKED_ENTRY_ID,
                ReadingListReaderDirection.PREVIOUS,
            )
        } returns expected
        val subject = ReadingListReaderDirectionalSkipNavigator(repository, navigator)

        val result = subject.skip(
            readingListId = READING_LIST_ID,
            blockedEntryId = BLOCKED_ENTRY_ID,
            direction = ReadingListReaderDirection.PREVIOUS,
        ).shouldBeInstanceOf<ReadingListReaderResult.Ready>()

        result.destination shouldBe expected.destination
        result.destination.openAtEnd shouldBe true
        coVerify(exactly = 1) {
            repository.setEntrySkipped(READING_LIST_ID, BLOCKED_ENTRY_ID, skipped = true)
        }
        coVerify(exactly = 1) {
            navigator.move(
                READING_LIST_ID,
                BLOCKED_ENTRY_ID,
                ReadingListReaderDirection.PREVIOUS,
            )
        }
        coVerify(exactly = 0) { navigator.skip(any(), any()) }
    }

    @Test
    fun `backward skip preserves a second blocked decision instead of bypassing it`() = runTest {
        val repository = mockk<ReadingListRepository>()
        val navigator = mockk<ReadingListReaderNavigator>()
        val readingList = readingList(
            entries = listOf(
                entry(SECOND_BLOCKED_ENTRY_ID, position = 1),
                entry(BLOCKED_ENTRY_ID, position = 2),
            ),
        )
        val secondBlocked = ReadingListReaderBlockedEntry(
            readingListId = READING_LIST_ID,
            readingListName = "Fixture",
            entryId = SECOND_BLOCKED_ENTRY_ID,
            position = 1,
            entryCount = 3,
            series = "Series 1",
            issueNumber = "2",
            reason = ReadingListReaderBlockReason.UNRESOLVED,
        )
        coEvery { repository.get(READING_LIST_ID) } returns readingList
        coEvery {
            repository.setEntrySkipped(READING_LIST_ID, BLOCKED_ENTRY_ID, skipped = true)
        } returns true
        coEvery {
            navigator.move(
                READING_LIST_ID,
                BLOCKED_ENTRY_ID,
                ReadingListReaderDirection.PREVIOUS,
            )
        } returns ReadingListReaderResult.Blocked(secondBlocked)
        val subject = ReadingListReaderDirectionalSkipNavigator(repository, navigator)

        val result = subject.skip(
            readingListId = READING_LIST_ID,
            blockedEntryId = BLOCKED_ENTRY_ID,
            direction = ReadingListReaderDirection.PREVIOUS,
        ).shouldBeInstanceOf<ReadingListReaderResult.Blocked>()

        result.entry shouldBe secondBlocked
    }

    private fun readingList(entries: List<ReadingListEntry>): ReadingList {
        return ReadingList(
            id = READING_LIST_ID,
            name = "Fixture",
            description = null,
            declaredIssueCount = entries.size,
            entries = entries,
            selectedSourceIds = listOf(1L),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            warnings = emptyList(),
            currentPosition = 0,
            createdAt = 1L,
            updatedAt = 1L,
            completed = false,
        )
    }

    private fun entry(id: Long, position: Int): ReadingListEntry {
        return ReadingListEntry(
            id = id,
            readingListId = READING_LIST_ID,
            position = position,
            series = "Series $position",
            number = (position + 1).toString(),
            volume = null,
            year = null,
            databases = emptyList(),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            resolutionState = ReadingListEntryResolutionState.UNRESOLVED,
            matchedSourceId = null,
            matchedMangaUrl = null,
            matchedChapterUrl = null,
            confidence = null,
            matcherVersion = null,
            userConfirmed = false,
            skipped = false,
        )
    }

    private companion object {
        const val READING_LIST_ID = 1L
        const val PREVIOUS_ENTRY_ID = 9L
        const val SECOND_BLOCKED_ENTRY_ID = 10L
        const val BLOCKED_ENTRY_ID = 11L
    }
}
