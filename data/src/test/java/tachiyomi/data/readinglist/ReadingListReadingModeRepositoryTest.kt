package tachiyomi.data.readinglist

import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
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
import tachiyomi.data.StringListColumnAdapter
import tachiyomi.data.UpdateStrategyColumnAdapter
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState

@Execution(ExecutionMode.CONCURRENT)
class ReadingListReadingModeRepositoryTest {

    @Test
    fun `reading mode remains list specific and does not change progress`() = runTest {
        withRepository { repository, database, readingListId ->
            repository.get(readingListId)!!.let { readingList ->
                readingList.readingMode shouldBe null
                readingList.currentPosition shouldBe null
                readingList.completed shouldBe false
            }

            repository.updateProgress(
                id = readingListId,
                currentPosition = 0,
                completed = false,
            ) shouldBe true
            repository.updateReadingMode(readingListId, readingMode = 1) shouldBe true

            repository.get(readingListId)!!.let { readingList ->
                readingList.readingMode shouldBe 1
                readingList.currentPosition shouldBe 0
                readingList.completed shouldBe false
            }

            repository.updateReadingMode(readingListId, readingMode = 4) shouldBe true
            repository.get(readingListId)!!.readingMode shouldBe 4
            database.reading_list_reader_settingsQueries
                .getReadingListReadingMode(readingListId)
                .awaitAsOne() shouldBe 4L
        }
    }

    @Test
    fun `missing list and unsupported modes are refused`() = runTest {
        withRepository { repository, _, readingListId ->
            repository.updateReadingMode(readingListId + 1, readingMode = 1) shouldBe false

            var failure: IllegalArgumentException? = null
            try {
                repository.updateReadingMode(readingListId, readingMode = 6)
            } catch (error: IllegalArgumentException) {
                failure = error
            }
            failure?.message shouldBe "Reading-list mode must use a supported reader mode"
            repository.get(readingListId)!!.readingMode shouldBe null
        }
    }

    @Test
    fun `deleting a reading list cascades its reader settings`() = runTest {
        withRepository { repository, database, readingListId ->
            repository.updateReadingMode(readingListId, readingMode = 2) shouldBe true

            repository.delete(readingListId)

            database.reading_list_reader_settingsQueries
                .getReadingListReadingMode(readingListId)
                .awaitAsOneOrNull() shouldBe null
        }
    }

    private suspend fun withRepository(
        block: suspend (ReadingListRepositoryImpl, Database, Long) -> Unit,
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
            queries.insertReadingList(
                name = "Reader mode fixture",
                description = null,
                declaredIssueCount = 1,
                extraAttributes = "{}",
                extraElements = "{}",
                warnings = "[]",
                createdAt = 1L,
                updatedAt = 1L,
            )
            val readingListId = queries.lastInsertRowId().awaitAsOne()
            queries.insertReadingListEntry(
                readingListId = readingListId,
                position = 0L,
                series = "Series",
                number = "1",
                volume = null,
                year = null,
                extraAttributes = "{}",
                extraElements = "{}",
                resolutionState = ReadingListEntryResolutionState.UNSEARCHED.name,
            )
            queries.insertReadingListSource(
                readingListId = readingListId,
                sourceId = 1L,
                position = 0L,
            )

            val repository = ReadingListRepositoryImpl(
                database = database,
                json = Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                },
                currentTimeMillis = { 2L },
            )
            block(repository, database, readingListId)
        } finally {
            driver.close()
        }
    }
}
