package tachiyomi.data.readinglist

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
class ReadingListProgressRepositoryTest {

    @Test
    fun `progress and completion remain list specific`() = runTest {
        withRepository { repository, _, fixture ->
            repository.get(fixture.readingListId)!!.let { readingList ->
                readingList.currentPosition shouldBe null
                readingList.completed shouldBe false
            }

            repository.updateProgress(
                id = fixture.readingListId,
                currentPosition = 1,
                completed = false,
            ) shouldBe true

            repository.get(fixture.readingListId)!!.let { readingList ->
                readingList.currentPosition shouldBe 1
                readingList.completed shouldBe false
            }
            repository.getAll().single().let { summary ->
                summary.currentPosition shouldBe 1
                summary.completed shouldBe false
            }

            repository.updateProgress(
                id = fixture.readingListId,
                currentPosition = null,
                completed = true,
            ) shouldBe true

            repository.get(fixture.readingListId)!!.let { readingList ->
                readingList.currentPosition shouldBe null
                readingList.completed shouldBe true
            }
            repository.getAll().single().let { summary ->
                summary.currentPosition shouldBe null
                summary.completed shouldBe true
            }
        }
    }

    @Test
    fun `invalid position is refused without changing stored progress`() = runTest {
        withRepository { repository, _, fixture ->
            repository.updateProgress(
                id = fixture.readingListId,
                currentPosition = 0,
                completed = false,
            ) shouldBe true

            repository.updateProgress(
                id = fixture.readingListId,
                currentPosition = 2,
                completed = false,
            ) shouldBe false

            repository.get(fixture.readingListId)!!.let { readingList ->
                readingList.currentPosition shouldBe 0
                readingList.completed shouldBe false
            }
        }
    }

    @Test
    fun `missing list progress update is refused`() = runTest {
        withRepository { repository, _, _ ->
            repository.updateProgress(
                id = Long.MAX_VALUE,
                currentPosition = 0,
                completed = false,
            ) shouldBe false
        }
    }

    @Test
    fun `completed list cannot retain a current position`() = runTest {
        withRepository { repository, _, fixture ->
            var failure: IllegalArgumentException? = null

            try {
                repository.updateProgress(
                    id = fixture.readingListId,
                    currentPosition = 0,
                    completed = true,
                )
            } catch (error: IllegalArgumentException) {
                failure = error
            }

            failure?.message shouldBe "A completed reading list cannot point to a current entry"
            repository.get(fixture.readingListId)!!.let { readingList ->
                readingList.currentPosition shouldBe null
                readingList.completed shouldBe false
            }
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
            name = "Progress fixture",
            description = null,
            declaredIssueCount = 2,
            extraAttributes = "{}",
            extraElements = "{}",
            warnings = "[]",
            createdAt = 1,
            updatedAt = 1,
        )
        val readingListId = queries.lastInsertRowId().awaitAsOne()

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
        }

        return Fixture(readingListId)
    }

    private data class Fixture(
        val readingListId: Long,
    )
}
