package tachiyomi.data.readinglist

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import tachiyomi.data.Chapters
import tachiyomi.data.Database
import tachiyomi.data.DateColumnAdapter
import tachiyomi.data.History
import tachiyomi.data.Mangas
import tachiyomi.data.MemoColumnAdapter
import tachiyomi.data.Reading_listsQueries
import tachiyomi.data.StringListColumnAdapter
import tachiyomi.data.UpdateStrategyColumnAdapter
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState

@Execution(ExecutionMode.CONCURRENT)
class ReadingListReaderStateRepositoryTest {

    @Test
    fun `skip preserves resolved identity and affects only the requested list entry`() = runTest {
        withRepository { repository, queries, fixture ->
            queries.applyAutomaticResolution(
                resolutionState = ReadingListEntryResolutionState.AUTO_MATCHED.name,
                matchedSourceId = 7,
                matchedMangaUrl = "/series/exact",
                matchedChapterUrl = "/chapter/exact",
                confidence = 93.0,
                matcherVersion = 2,
                entryId = fixture.firstEntryId,
            )

            repository.setEntrySkipped(
                readingListId = fixture.readingListId,
                entryId = fixture.firstEntryId,
                skipped = true,
            ) shouldBe true

            val entries = queries.getReadingListEntries(fixture.readingListId).awaitAsList()
            entries.first().let { entry ->
                entry.skipped shouldBe true
                entry.resolutionState shouldBe ReadingListEntryResolutionState.AUTO_MATCHED.name
                entry.matchedSourceId shouldBe 7
                entry.matchedMangaUrl shouldBe "/series/exact"
                entry.matchedChapterUrl shouldBe "/chapter/exact"
            }
            entries.last().skipped shouldBe false

            repository.setEntrySkipped(
                readingListId = fixture.readingListId + 1,
                entryId = fixture.firstEntryId,
                skipped = false,
            ) shouldBe false
            queries.getReadingListEntries(fixture.readingListId).awaitAsList().first().skipped shouldBe true
        }
    }

    @Test
    fun `reader failure preserves user confirmed mapping and clear restores protection`() = runTest {
        withRepository { repository, queries, fixture ->
            queries.confirmResolution(
                matchedSourceId = 9,
                matchedMangaUrl = "/series/confirmed",
                matchedChapterUrl = "/chapter/confirmed",
                confidence = 100.0,
                matcherVersion = 2,
                entryId = fixture.firstEntryId,
            )

            repository.markEntryReaderFailure(
                entryId = fixture.firstEntryId,
                state = ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            ) shouldBe true

            queries.getReadingListEntries(fixture.readingListId).awaitAsList().first().let { entry ->
                entry.resolutionState shouldBe ReadingListEntryResolutionState.SOURCE_UNAVAILABLE.name
                entry.userConfirmed shouldBe true
                entry.matchedSourceId shouldBe 9
                entry.matchedMangaUrl shouldBe "/series/confirmed"
                entry.matchedChapterUrl shouldBe "/chapter/confirmed"
            }

            repository.clearEntryReaderFailure(fixture.firstEntryId) shouldBe true

            queries.getReadingListEntries(fixture.readingListId).awaitAsList().first().let { entry ->
                entry.resolutionState shouldBe ReadingListEntryResolutionState.USER_CONFIRMED.name
                entry.userConfirmed shouldBe true
                entry.matchedSourceId shouldBe 9
                entry.matchedMangaUrl shouldBe "/series/confirmed"
                entry.matchedChapterUrl shouldBe "/chapter/confirmed"
            }
        }
    }

    @Test
    fun `reader failure clear restores automatic match when identity remains`() = runTest {
        withRepository { repository, queries, fixture ->
            queries.applyAutomaticResolution(
                resolutionState = ReadingListEntryResolutionState.AUTO_MATCHED.name,
                matchedSourceId = 7,
                matchedMangaUrl = "/series/automatic",
                matchedChapterUrl = "/chapter/automatic",
                confidence = 93.0,
                matcherVersion = 2,
                entryId = fixture.firstEntryId,
            )

            repository.markEntryReaderFailure(
                entryId = fixture.firstEntryId,
                state = ReadingListEntryResolutionState.CHAPTER_REMOVED,
            ) shouldBe true
            repository.clearEntryReaderFailure(fixture.firstEntryId) shouldBe true

            queries.getReadingListEntries(fixture.readingListId).awaitAsList().first().let { entry ->
                entry.resolutionState shouldBe ReadingListEntryResolutionState.AUTO_MATCHED.name
                entry.userConfirmed shouldBe false
                entry.matchedSourceId shouldBe 7
                entry.matchedMangaUrl shouldBe "/series/automatic"
                entry.matchedChapterUrl shouldBe "/chapter/automatic"
            }
        }
    }

    @Test
    fun `reader failure rejects non repairable states`() = runTest {
        withRepository { repository, _, fixture ->
            var failure: IllegalArgumentException? = null

            try {
                repository.markEntryReaderFailure(
                    entryId = fixture.firstEntryId,
                    state = ReadingListEntryResolutionState.UNRESOLVED,
                )
            } catch (error: IllegalArgumentException) {
                failure = error
            }

            failure?.message shouldBe "Reader failures may only use a repairable resolution state"
        }
    }

    private suspend fun withRepository(
        block: suspend (
            ReadingListRepositoryImpl,
            Reading_listsQueries,
            Fixture,
        ) -> Unit,
    ) {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        try {
            Database.Schema.create(driver).await()
            driver.execute(null, "PRAGMA foreign_keys = ON", 0).await()
            val database = Database(
                driver = driver,
                historyAdapter = History.Adapter(last_readAdapter = DateColumnAdapter),
                mangasAdapter = Mangas.Adapter(
                    genreAdapter = StringListColumnAdapter,
                    update_strategyAdapter = UpdateStrategyColumnAdapter,
                    memoAdapter = MemoColumnAdapter,
                ),
                chaptersAdapter = Chapters.Adapter(memoAdapter = MemoColumnAdapter),
            )
            val queries = database.reading_listsQueries
            val fixture = insertFixture(queries)
            val repository = ReadingListRepositoryImpl(
                database = database,
                json = Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                },
                currentTimeMillis = { 2L },
            )
            block(repository, queries, fixture)
        } finally {
            driver.close()
        }
    }

    private suspend fun insertFixture(queries: Reading_listsQueries): Fixture {
        queries.insertReadingList(
            name = "Reader-state fixture",
            description = null,
            declaredIssueCount = 2,
            extraAttributes = "{}",
            extraElements = "{}",
            warnings = "[]",
            createdAt = 1,
            updatedAt = 1,
        )
        val readingListId = queries.lastInsertRowId().awaitAsOne()

        val entryIds = mutableListOf<Long>()
        repeat(2) { position ->
            queries.insertReadingListEntry(
                readingListId = readingListId,
                position = position.toLong(),
                series = "Series $position",
                number = (position + 1).toString(),
                volume = null,
                year = null,
                extraAttributes = "{}",
                extraElements = "{}",
                resolutionState = ReadingListEntryResolutionState.UNSEARCHED.name,
            )
            entryIds += queries.lastInsertRowId().awaitAsOne()
        }

        return Fixture(
            readingListId = readingListId,
            firstEntryId = entryIds.first(),
        )
    }

    private data class Fixture(
        val readingListId: Long,
        val firstEntryId: Long,
    )
}
