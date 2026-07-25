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
import io.mockk.coVerify
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

class ReadingListReaderSourceAvailabilityTest {

    @Test
    fun `disabled extension blocks before cached rows can be reused`() = runTest {
        val fixture = fixture(
            resolutionState = ReadingListEntryResolutionState.USER_CONFIRMED,
            sourceAvailable = false,
        )

        val blocked = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()

        blocked.entry.reason shouldBe ReadingListReaderBlockReason.SOURCE_UNAVAILABLE
        coVerify(exactly = 1) {
            fixture.readingListRepository.markEntryReaderFailure(
                ENTRY_ID,
                ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            )
        }
        coVerify(exactly = 0) {
            fixture.mangaRepository.getMangaByUrlAndSourceId(any(), any())
        }
        fixture.source.updateCalls shouldBe 0
    }

    @Test
    fun `reinstalled extension restores the exact unavailable mapping without another candidate search`() = runTest {
        val fixture = fixture(
            resolutionState = ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            sourceAvailable = true,
        )

        val ready = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()

        ready.destination.entryId shouldBe ENTRY_ID
        ready.destination.mangaId shouldBe MANGA_ID
        ready.destination.chapterId shouldBe CHAPTER_ID
        coVerify(exactly = 1) {
            fixture.readingListRepository.clearEntryReaderFailure(ENTRY_ID)
        }
        coVerify(exactly = 1) {
            fixture.readingListRepository.updateProgress(READING_LIST_ID, 0, false)
        }
        coVerify(exactly = 0) {
            fixture.readingListRepository.markEntryReaderFailure(any(), any())
        }
        fixture.source.updateCalls shouldBe 0
    }

    private fun fixture(
        resolutionState: ReadingListEntryResolutionState,
        sourceAvailable: Boolean,
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
            resolutionState = resolutionState,
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
            currentPosition = null,
            createdAt = 1,
            updatedAt = 1,
            completed = false,
        )
        val manga = Manga.create().copy(
            id = MANGA_ID,
            source = source.id,
            url = MANGA_URL,
            title = "Series",
            favorite = false,
        )
        val chapter = Chapter.create().copy(
            id = CHAPTER_ID,
            mangaId = MANGA_ID,
            url = CHAPTER_URL,
            name = "Series #1",
            chapterNumber = 1.0,
        )
        val readingListRepository = mockk<ReadingListRepository>()
        val mangaRepository = mockk<MangaRepository>()
        val chapterRepository = mockk<ChapterRepository>()
        coEvery { readingListRepository.get(READING_LIST_ID) } returns readingList
        coEvery { readingListRepository.updateProgress(any(), any(), any()) } returns true
        coEvery { readingListRepository.markEntryReaderFailure(any(), any()) } returns true
        coEvery { readingListRepository.clearEntryReaderFailure(any()) } returns true
        coEvery { mangaRepository.getMangaByUrlAndSourceId(MANGA_URL, source.id) } returns manga
        coEvery { chapterRepository.getChapterByUrlAndMangaId(CHAPTER_URL, MANGA_ID) } returns chapter
        coEvery { mangaRepository.insertNetworkManga(any()) } returns emptyList()
        coEvery { chapterRepository.addAll(any()) } returns emptyList()

        return Fixture(
            navigator = ReadingListReaderNavigator(
                readingListRepository = readingListRepository,
                mangaRepository = mangaRepository,
                chapterRepository = chapterRepository,
                sourceManager = FakeSourceManager(source),
                sourceAvailability = ReadingListSourceAvailability { sourceAvailable },
            ),
            readingListRepository = readingListRepository,
            mangaRepository = mangaRepository,
            source = source,
        )
    }

    private data class Fixture(
        val navigator: ReadingListReaderNavigator,
        val readingListRepository: ReadingListRepository,
        val mangaRepository: MangaRepository,
        val source: FakeHttpSource,
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

        var updateCalls: Int = 0
            private set

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
        ): SMangaUpdate {
            updateCalls += 1
            error("Cached rows should be reused in this fixture")
        }
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
