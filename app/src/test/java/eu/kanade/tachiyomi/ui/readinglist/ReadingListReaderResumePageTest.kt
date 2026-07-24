package eu.kanade.tachiyomi.ui.readinglist

import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.source.model.SMangaUpdate
import eu.kanade.tachiyomi.source.online.HttpSource
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import tachiyomi.domain.chapter.model.Chapter
import tachiyomi.domain.chapter.repository.ChapterRepository
import tachiyomi.domain.manga.model.Manga
import tachiyomi.domain.manga.repository.MangaRepository
import tachiyomi.domain.readinglist.model.ReadingList
import tachiyomi.domain.readinglist.model.ReadingListEntry
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.repository.ReadingListRepository
import tachiyomi.domain.source.model.StubSource
import tachiyomi.domain.source.service.SourceManager

class ReadingListReaderResumePageTest {

    @Test
    fun `resume retains the shared page even when the chapter is already read`() = runTest {
        val fixture = fixture(currentPosition = 0, chapterRead = true, lastPageRead = 99)

        val ready = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()

        ready.destination.openAtEnd shouldBe false
        ready.destination.resumePage shouldBe 99
    }

    @Test
    fun `new and restarted lists ignore shared page progress`() = runTest {
        val newList = fixture(currentPosition = null, chapterRead = true, lastPageRead = 99)
        newList.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()
            .destination.resumePage shouldBe null

        val restarted = fixture(
            currentPosition = 0,
            completed = true,
            chapterRead = true,
            lastPageRead = 99,
        )
        restarted.navigator.start(READING_LIST_ID, restartCompleted = true)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()
            .destination.resumePage shouldBe null
    }

    @Test
    fun `initial page policy gives previous boundaries priority and clamps resume pages`() {
        resolveReadingListInitialPage(
            openAtEnd = true,
            resumePage = 3,
            lastPageIndex = 9,
        ) shouldBe 9
        resolveReadingListInitialPage(
            openAtEnd = false,
            resumePage = 99,
            lastPageIndex = 9,
        ) shouldBe 9
        resolveReadingListInitialPage(
            openAtEnd = false,
            resumePage = null,
            lastPageIndex = 9,
        ) shouldBe null
        resolveReadingListInitialPage(
            openAtEnd = true,
            resumePage = null,
            lastPageIndex = -1,
        ) shouldBe null
    }

    private fun fixture(
        currentPosition: Int?,
        completed: Boolean = false,
        chapterRead: Boolean,
        lastPageRead: Long,
    ): Fixture {
        val source = FakeHttpSource()
        val entry = ReadingListEntry(
            id = ENTRY_ID,
            readingListId = READING_LIST_ID,
            position = 0,
            series = "Series",
            number = "1",
            volume = null,
            year = null,
            databases = emptyList(),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            resolutionState = ReadingListEntryResolutionState.USER_CONFIRMED,
            matchedSourceId = source.id,
            matchedMangaUrl = MANGA_URL,
            matchedChapterUrl = CHAPTER_URL,
            confidence = 100.0,
            matcherVersion = 1,
            userConfirmed = true,
            skipped = false,
        )
        val readingList = ReadingList(
            id = READING_LIST_ID,
            name = "Fixture",
            description = null,
            declaredIssueCount = 1,
            entries = listOf(entry),
            selectedSourceIds = listOf(source.id),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            warnings = emptyList(),
            currentPosition = currentPosition,
            createdAt = 1,
            updatedAt = 1,
            completed = completed,
        )
        val manga = Manga.create().copy(
            id = MANGA_ID,
            source = source.id,
            url = MANGA_URL,
            title = "Series",
        )
        val chapter = Chapter.create().copy(
            id = CHAPTER_ID,
            mangaId = MANGA_ID,
            read = chapterRead,
            lastPageRead = lastPageRead,
            url = CHAPTER_URL,
            name = "Series #1",
            chapterNumber = 1.0,
        )
        val readingListRepository = mockk<ReadingListRepository>()
        val mangaRepository = mockk<MangaRepository>()
        val chapterRepository = mockk<ChapterRepository>()
        coEvery { readingListRepository.get(READING_LIST_ID) } returns readingList
        coEvery { readingListRepository.updateProgress(any(), any(), any()) } returns true
        coEvery { mangaRepository.getMangaByUrlAndSourceId(MANGA_URL, source.id) } returns manga
        coEvery { chapterRepository.getChapterByUrlAndMangaId(CHAPTER_URL, MANGA_ID) } returns chapter

        return Fixture(
            navigator = ReadingListReaderNavigator(
                readingListRepository = readingListRepository,
                mangaRepository = mangaRepository,
                chapterRepository = chapterRepository,
                sourceManager = FakeSourceManager(source),
            ),
        )
    }

    private data class Fixture(
        val navigator: ReadingListReaderNavigator,
    )

    private class FakeSourceManager(source: Source) : SourceManager {
        private val sourceMap = mapOf(source.id to source)

        override val isInitialized: StateFlow<Boolean> = MutableStateFlow(true)
        override val sources: Flow<List<Source>> = MutableStateFlow(sourceMap.values.toList())

        override fun get(sourceKey: Long): Source? = sourceMap[sourceKey]

        override fun getOrStub(sourceKey: Long): Source {
            return sourceMap[sourceKey] ?: StubSource(
                id = sourceKey,
                lang = "",
                name = "",
            )
        }

        override fun getAll(): List<Source> = sourceMap.values.toList()
        override fun getOnlineSources(): List<HttpSource> = sourceMap.values.filterIsInstance<HttpSource>()
        override fun getStubSources(): List<StubSource> = emptyList()
    }

    private class FakeHttpSource : HttpSource() {
        override val name: String = "Selected"
        override val lang: String = "en"
        override val supportsLatest: Boolean = false
        override val baseUrl: String = "https://example.invalid"

        override suspend fun getSearchManga(
            page: Int,
            query: String,
            filters: FilterList,
        ): MangasPage = MangasPage(emptyList(), false)

        override suspend fun getMangaUpdate(
            manga: SManga,
            chapters: List<SChapter>,
            fetchDetails: Boolean,
            fetchChapters: Boolean,
        ): SMangaUpdate = error("Existing local rows should be reused")
    }

    private companion object {
        const val READING_LIST_ID = 1L
        const val ENTRY_ID = 10L
        const val MANGA_ID = 100L
        const val CHAPTER_ID = 200L
        const val MANGA_URL = "/series"
        const val CHAPTER_URL = "/chapter"
    }
}
