package eu.kanade.tachiyomi.ui.readinglist

import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.source.model.SMangaUpdate
import eu.kanade.tachiyomi.source.online.HttpSource
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.delay
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

class ReadingListReaderNavigatorTest {

    @Test
    fun `start opens position zero in cbl order even when repository entries are unsorted`() = runTest {
        val source = FakeHttpSource()
        val first = readableEntry(
            id = 10,
            position = 0,
            sourceId = source.id,
            mangaUrl = "/series/first",
            chapterUrl = "/chapter/first",
        )
        val second = readableEntry(
            id = 11,
            position = 1,
            sourceId = source.id,
            mangaUrl = "/series/second",
            chapterUrl = "/chapter/second",
        )
        val fixture = fixture(
            readingList = readingList(entries = listOf(second, first), sourceIds = listOf(source.id)),
            sources = listOf(source),
            localRows = mapOf(first to localRows(first, mangaId = 100, chapterId = 200)),
        )

        val result = fixture.navigator.start(READING_LIST_ID)

        val ready = result.shouldBeInstanceOf<ReadingListReaderResult.Ready>()
        ready.destination.entryId shouldBe first.id
        ready.destination.position shouldBe 0
        ready.destination.mangaId shouldBe 100
        ready.destination.chapterId shouldBe 200
        ready.destination.hasPrevious shouldBe false
        ready.destination.hasNext shouldBe true
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, 0, false) }
        source.updateCalls shouldBe 0
    }

    @Test
    fun `start resumes persisted position independently of shared chapter read state`() = runTest {
        val source = FakeHttpSource()
        val first = readableEntry(10, 0, source.id, "/series/first", "/chapter/first")
        val second = readableEntry(11, 1, source.id, "/series/second", "/chapter/second")
        val secondRows = localRows(second, mangaId = 101, chapterId = 201).let { rows ->
            rows.copy(chapter = rows.chapter.copy(read = true, lastPageRead = 99L))
        }
        val fixture = fixture(
            readingList = readingList(
                entries = listOf(first, second),
                sourceIds = listOf(source.id),
                currentPosition = 1,
            ),
            sources = listOf(source),
            localRows = mapOf(second to secondRows),
        )

        val result = fixture.navigator.start(READING_LIST_ID)

        val ready = result.shouldBeInstanceOf<ReadingListReaderResult.Ready>()
        ready.destination.entryId shouldBe second.id
        ready.destination.position shouldBe 1
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, 1, false) }
    }

    @Test
    fun `completed list requires explicit restart and restart clears completion at position zero`() = runTest {
        val source = FakeHttpSource()
        val entry = readableEntry(10, 0, source.id, "/series/first", "/chapter/first")
        val list = readingList(
            entries = listOf(entry),
            sourceIds = listOf(source.id),
            completed = true,
        )
        val fixture = fixture(
            readingList = list,
            sources = listOf(source),
            localRows = mapOf(entry to localRows(entry, mangaId = 100, chapterId = 200)),
        )

        fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Completed>()
        coVerify(exactly = 0) { fixture.readingListRepository.updateProgress(any(), any(), any()) }

        val restarted = fixture.navigator.start(READING_LIST_ID, restartCompleted = true)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()
        restarted.destination.position shouldBe 0
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, 0, false) }
    }

    @Test
    fun `empty list completes without pointing progress at a missing entry`() = runTest {
        val fixture = fixture(readingList = readingList(entries = emptyList(), sourceIds = listOf(1)))

        val result = fixture.navigator.start(READING_LIST_ID)

        result.shouldBeInstanceOf<ReadingListReaderResult.Completed>()
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, null, true) }
    }

    @Test
    fun `next and previous follow cbl positions instead of repository or manga order`() = runTest {
        val sourceA = FakeHttpSource(sourceName = "A")
        val sourceB = FakeHttpSource(sourceName = "B")
        val first = readableEntry(10, 0, sourceA.id, "/series/shared", "/chapter/10")
        val second = readableEntry(11, 1, sourceB.id, "/series/other", "/chapter/1")
        val third = readableEntry(12, 2, sourceA.id, "/series/shared", "/chapter/2")
        val list = readingList(
            entries = listOf(third, first, second),
            sourceIds = listOf(sourceA.id, sourceB.id),
        )
        val fixture = fixture(
            readingList = list,
            sources = listOf(sourceA, sourceB),
            localRows = mapOf(
                first to localRows(first, 100, 200),
                second to localRows(second, 101, 201),
                third to localRows(third, 100, 202),
            ),
        )

        val next = fixture.navigator.move(
            readingListId = READING_LIST_ID,
            currentEntryId = first.id,
            direction = ReadingListReaderDirection.NEXT,
        ).shouldBeInstanceOf<ReadingListReaderResult.Ready>()
        next.destination.entryId shouldBe second.id
        next.destination.mangaId shouldBe 101

        val previous = fixture.navigator.move(
            readingListId = READING_LIST_ID,
            currentEntryId = third.id,
            direction = ReadingListReaderDirection.PREVIOUS,
        ).shouldBeInstanceOf<ReadingListReaderResult.Ready>()
        previous.destination.entryId shouldBe second.id
    }

    @Test
    fun `previous before first is a boundary and next after final completes the list`() = runTest {
        val source = FakeHttpSource()
        val entry = readableEntry(10, 0, source.id, "/series/first", "/chapter/first")
        val fixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(source.id)),
            sources = listOf(source),
            localRows = mapOf(entry to localRows(entry, 100, 200)),
        )

        val previous = fixture.navigator.move(
            READING_LIST_ID,
            entry.id,
            ReadingListReaderDirection.PREVIOUS,
        ).shouldBeInstanceOf<ReadingListReaderResult.Boundary>()
        previous.direction shouldBe ReadingListReaderDirection.PREVIOUS

        val next = fixture.navigator.move(
            READING_LIST_ID,
            entry.id,
            ReadingListReaderDirection.NEXT,
        )
        next.shouldBeInstanceOf<ReadingListReaderResult.Completed>()
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, null, true) }
    }

    @Test
    fun `every unresolved resolution state blocks at its exact entry`() = runTest {
        val expected = mapOf(
            ReadingListEntryResolutionState.UNSEARCHED to ReadingListReaderBlockReason.UNSEARCHED,
            ReadingListEntryResolutionState.SEARCHING to ReadingListReaderBlockReason.SEARCHING,
            ReadingListEntryResolutionState.AMBIGUOUS to ReadingListReaderBlockReason.AMBIGUOUS,
            ReadingListEntryResolutionState.UNRESOLVED to ReadingListReaderBlockReason.UNRESOLVED,
            ReadingListEntryResolutionState.SOURCE_UNAVAILABLE to ReadingListReaderBlockReason.SOURCE_UNAVAILABLE,
            ReadingListEntryResolutionState.CHAPTER_REMOVED to ReadingListReaderBlockReason.CHAPTER_REMOVED,
            ReadingListEntryResolutionState.NEEDS_REMATCH to ReadingListReaderBlockReason.NEEDS_REMATCH,
        )

        expected.forEach { (state, reason) ->
            val entry = entry(id = 10, position = 0, state = state)
            val fixture = fixture(readingList = readingList(entries = listOf(entry), sourceIds = listOf(1)))

            val blocked = fixture.navigator.start(READING_LIST_ID)
                .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()
            blocked.entry.entryId shouldBe entry.id
            blocked.entry.position shouldBe 0
            blocked.entry.reason shouldBe reason
            coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, 0, false) }
        }
    }

    @Test
    fun `skipped entry and incomplete identities block without contacting a source`() = runTest {
        val source = FakeHttpSource()
        val skipped = readableEntry(10, 0, source.id, "/series", "/chapter").copy(skipped = true)
        val skippedFixture = fixture(
            readingList = readingList(entries = listOf(skipped), sourceIds = listOf(source.id)),
            sources = listOf(source),
        )
        skippedFixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()
            .entry.reason shouldBe ReadingListReaderBlockReason.SKIPPED

        val missingIdentity = readableEntry(11, 0, source.id, "/series", "/chapter")
            .copy(matchedChapterUrl = null)
        val identityFixture = fixture(
            readingList = readingList(entries = listOf(missingIdentity), sourceIds = listOf(source.id)),
            sources = listOf(source),
        )
        identityFixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()
            .entry.reason shouldBe ReadingListReaderBlockReason.MISSING_MATCH_IDENTITY

        source.updateCalls shouldBe 0
    }

    @Test
    fun `unselected and unavailable sources never fall back to another selected source`() = runTest {
        val savedSource = FakeHttpSource(sourceName = "Saved")
        val otherSource = FakeHttpSource(sourceName = "Other")
        val entry = readableEntry(10, 0, savedSource.id, "/series", "/chapter")
        val unselectedFixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(otherSource.id)),
            sources = listOf(savedSource, otherSource),
        )

        val unselected = unselectedFixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()
        unselected.entry.reason shouldBe ReadingListReaderBlockReason.SOURCE_NOT_SELECTED
        coVerify {
            unselectedFixture.stateStore.markFailure(
                entry.id,
                ReadingListEntryResolutionState.NEEDS_REMATCH,
            )
        }
        savedSource.updateCalls shouldBe 0
        otherSource.updateCalls shouldBe 0

        val unavailableFixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(savedSource.id)),
            sources = listOf(otherSource),
        )
        val unavailable = unavailableFixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()
        unavailable.entry.reason shouldBe ReadingListReaderBlockReason.SOURCE_UNAVAILABLE
        coVerify {
            unavailableFixture.stateStore.markFailure(
                entry.id,
                ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            )
        }
        otherSource.updateCalls shouldBe 0
    }

    @Test
    fun `existing exact local manga and chapter are reused without extension requests`() = runTest {
        val source = FakeHttpSource()
        val entry = readableEntry(10, 0, source.id, "/series", "/chapter")
        val rows = localRows(entry, mangaId = 100, chapterId = 200)
        val fixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(source.id)),
            sources = listOf(source),
            localRows = mapOf(entry to rows),
        )

        val ready = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()

        ready.destination.mangaId shouldBe rows.manga.id
        ready.destination.chapterId shouldBe rows.chapter.id
        source.updateCalls shouldBe 0
        coVerify(exactly = 0) { fixture.mangaRepository.insertNetworkManga(any()) }
        coVerify(exactly = 0) { fixture.chapterRepository.addAll(any()) }
    }

    @Test
    fun `explicit read materializes only the exact non-favorite manga and chapter`() = runTest {
        val source = FakeHttpSource(
            remoteManga = remoteManga("/series", "Remote series"),
            remoteChapters = listOf(
                remoteChapter("/chapter/wrong", "Wrong", 1f),
                remoteChapter("/chapter/exact", "Exact", 2f),
            ),
        )
        val entry = readableEntry(10, 0, source.id, "/series", "/chapter/exact")
        val insertedMangas = mutableListOf<Manga>()
        val insertedChapters = mutableListOf<Chapter>()
        val insertedManga = Manga.create().copy(
            id = 100,
            source = source.id,
            url = "/series",
            title = "Remote series",
            favorite = false,
        )
        val insertedChapter = Chapter.create().copy(
            id = 200,
            mangaId = insertedManga.id,
            url = "/chapter/exact",
            name = "Exact",
            chapterNumber = 2.0,
        )
        val fixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(source.id)),
            sources = listOf(source),
            mangaInsert = { mangas ->
                insertedMangas += mangas
                listOf(insertedManga)
            },
            chapterInsert = { chapters ->
                insertedChapters += chapters
                listOf(insertedChapter)
            },
        )

        val ready = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Ready>()

        ready.destination.mangaId shouldBe insertedManga.id
        ready.destination.chapterId shouldBe insertedChapter.id
        source.updateCalls shouldBe 1
        insertedMangas.single().favorite shouldBe false
        insertedMangas.single().url shouldBe "/series"
        insertedChapters.map(Chapter::url).shouldContainExactly("/chapter/exact")
    }

    @Test
    fun `missing exact chapter marks only that entry as removed without synthetic substitution`() = runTest {
        val source = FakeHttpSource(
            remoteManga = remoteManga("/series", "Remote series"),
            remoteChapters = listOf(remoteChapter("/chapter/other", "Other", 1f)),
        )
        val entry = readableEntry(10, 0, source.id, "/series", "/chapter/missing")
        val fixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(source.id)),
            sources = listOf(source),
        )

        val blocked = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()

        blocked.entry.reason shouldBe ReadingListReaderBlockReason.CHAPTER_REMOVED
        coVerify {
            fixture.stateStore.markFailure(
                entry.id,
                ReadingListEntryResolutionState.CHAPTER_REMOVED,
            )
        }
        coVerify(exactly = 0) { fixture.mangaRepository.insertNetworkManga(any()) }
        coVerify(exactly = 0) { fixture.chapterRepository.addAll(any()) }
    }

    @Test
    fun `source timeout blocks the entry without losing its saved identity`() = runTest {
        val source = FakeHttpSource(requestDelayMillis = 100)
        val entry = readableEntry(10, 0, source.id, "/series", "/chapter")
        val fixture = fixture(
            readingList = readingList(entries = listOf(entry), sourceIds = listOf(source.id)),
            sources = listOf(source),
            requestTimeoutMillis = 10,
        )

        val blocked = fixture.navigator.start(READING_LIST_ID)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()

        blocked.entry.reason shouldBe ReadingListReaderBlockReason.SOURCE_REQUEST_FAILED
        blocked.entry.entryId shouldBe entry.id
        coVerify {
            fixture.stateStore.markFailure(
                entry.id,
                ReadingListEntryResolutionState.SOURCE_UNAVAILABLE,
            )
        }
    }

    @Test
    fun `explicit skip advances exactly one position and stops again when the following entry is blocked`() = runTest {
        val first = entry(10, 0, ReadingListEntryResolutionState.UNRESOLVED)
        val second = entry(11, 1, ReadingListEntryResolutionState.AMBIGUOUS)
        val original = readingList(entries = listOf(first, second), sourceIds = listOf(1))
        val refreshed = original.copy(entries = listOf(first.copy(skipped = true), second))
        val fixture = fixture(readingList = original)
        coEvery { fixture.readingListRepository.get(READING_LIST_ID) } returnsMany listOf(original, refreshed)

        val blocked = fixture.navigator.skip(READING_LIST_ID, first.id)
            .shouldBeInstanceOf<ReadingListReaderResult.Blocked>()

        blocked.entry.entryId shouldBe second.id
        blocked.entry.position shouldBe 1
        blocked.entry.reason shouldBe ReadingListReaderBlockReason.AMBIGUOUS
        coVerify(exactly = 1) { fixture.stateStore.setSkipped(READING_LIST_ID, first.id, true) }
        coVerify(exactly = 0) { fixture.stateStore.setSkipped(READING_LIST_ID, second.id, true) }
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, 1, false) }
    }

    @Test
    fun `skipping the final blocked entry completes only the list`() = runTest {
        val entry = entry(10, 0, ReadingListEntryResolutionState.UNRESOLVED)
        val fixture = fixture(readingList = readingList(entries = listOf(entry), sourceIds = listOf(1)))

        val result = fixture.navigator.skip(READING_LIST_ID, entry.id)

        result.shouldBeInstanceOf<ReadingListReaderResult.Completed>()
        coVerify { fixture.stateStore.setSkipped(READING_LIST_ID, entry.id, true) }
        coVerify { fixture.readingListRepository.updateProgress(READING_LIST_ID, null, true) }
    }

    private fun fixture(
        readingList: ReadingList,
        sources: List<Source> = emptyList(),
        localRows: Map<ReadingListEntry, LocalRows> = emptyMap(),
        mangaInsert: (List<Manga>) -> List<Manga> = { emptyList() },
        chapterInsert: (List<Chapter>) -> List<Chapter> = { emptyList() },
        requestTimeoutMillis: Long = 30_000,
    ): Fixture {
        val readingListRepository = mockk<ReadingListRepository>()
        val mangaRepository = mockk<MangaRepository>()
        val chapterRepository = mockk<ChapterRepository>()
        val stateStore = mockk<ReadingListReaderStateStore>()

        coEvery { readingListRepository.get(READING_LIST_ID) } returns readingList
        coEvery { readingListRepository.updateProgress(any(), any(), any()) } returns true
        coEvery { stateStore.setSkipped(any(), any(), any()) } returns true
        coEvery { stateStore.markFailure(any(), any()) } returns true
        coEvery { stateStore.clearFailure(any()) } returns true

        coEvery { mangaRepository.getMangaByUrlAndSourceId(any(), any()) } answers {
            val url = firstArg<String>()
            val sourceId = secondArg<Long>()
            localRows.values.firstOrNull { rows ->
                rows.manga.url == url && rows.manga.source == sourceId
            }?.manga
        }
        coEvery { chapterRepository.getChapterByUrlAndMangaId(any(), any()) } answers {
            val url = firstArg<String>()
            val mangaId = secondArg<Long>()
            localRows.values.firstOrNull { rows ->
                rows.chapter.url == url && rows.chapter.mangaId == mangaId
            }?.chapter
        }
        coEvery { mangaRepository.insertNetworkManga(any()) } answers {
            mangaInsert(firstArg())
        }
        coEvery { chapterRepository.addAll(any()) } answers {
            chapterInsert(firstArg())
        }

        return Fixture(
            navigator = ReadingListReaderNavigator(
                readingListRepository = readingListRepository,
                mangaRepository = mangaRepository,
                chapterRepository = chapterRepository,
                sourceManager = FakeSourceManager(sources),
                stateStore = stateStore,
                requestTimeoutMillis = requestTimeoutMillis,
            ),
            readingListRepository = readingListRepository,
            mangaRepository = mangaRepository,
            chapterRepository = chapterRepository,
            stateStore = stateStore,
        )
    }

    private fun readingList(
        entries: List<ReadingListEntry>,
        sourceIds: List<Long>,
        currentPosition: Int? = null,
        completed: Boolean = false,
    ): ReadingList {
        return ReadingList(
            id = READING_LIST_ID,
            name = "Fixture",
            description = null,
            declaredIssueCount = entries.size,
            entries = entries,
            selectedSourceIds = sourceIds,
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            warnings = emptyList(),
            currentPosition = currentPosition,
            createdAt = 1,
            updatedAt = 1,
            completed = completed,
        )
    }

    private fun readableEntry(
        id: Long,
        position: Int,
        sourceId: Long,
        mangaUrl: String,
        chapterUrl: String,
    ): ReadingListEntry {
        return entry(
            id = id,
            position = position,
            state = ReadingListEntryResolutionState.AUTO_MATCHED,
        ).copy(
            matchedSourceId = sourceId,
            matchedMangaUrl = mangaUrl,
            matchedChapterUrl = chapterUrl,
            confidence = 90.0,
            matcherVersion = 1,
        )
    }

    private fun entry(
        id: Long,
        position: Int,
        state: ReadingListEntryResolutionState,
    ): ReadingListEntry {
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
            resolutionState = state,
            matchedSourceId = null,
            matchedMangaUrl = null,
            matchedChapterUrl = null,
            confidence = null,
            matcherVersion = null,
            userConfirmed = state == ReadingListEntryResolutionState.USER_CONFIRMED,
            skipped = false,
        )
    }

    private fun localRows(
        entry: ReadingListEntry,
        mangaId: Long,
        chapterId: Long,
    ): LocalRows {
        val manga = Manga.create().copy(
            id = mangaId,
            source = requireNotNull(entry.matchedSourceId),
            url = requireNotNull(entry.matchedMangaUrl),
            title = entry.series,
            favorite = false,
        )
        val chapter = Chapter.create().copy(
            id = chapterId,
            mangaId = mangaId,
            url = requireNotNull(entry.matchedChapterUrl),
            name = "${entry.series} #${entry.number}",
            chapterNumber = entry.number.toDoubleOrNull() ?: -1.0,
        )
        return LocalRows(manga, chapter)
    }

    private data class Fixture(
        val navigator: ReadingListReaderNavigator,
        val readingListRepository: ReadingListRepository,
        val mangaRepository: MangaRepository,
        val chapterRepository: ChapterRepository,
        val stateStore: ReadingListReaderStateStore,
    )

    private data class LocalRows(
        val manga: Manga,
        val chapter: Chapter,
    )

    private class FakeSourceManager(
        sources: List<Source>,
    ) : SourceManager {
        private val sourceMap = sources.associateBy(Source::id)

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

    private class FakeHttpSource(
        sourceName: String = "Selected",
        private val remoteManga: SManga = remoteManga("/series", "Series"),
        private val remoteChapters: List<SChapter> = listOf(remoteChapter("/chapter", "Issue", 1f)),
        private val requestDelayMillis: Long = 0,
    ) : HttpSource() {
        override val name: String = sourceName
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
            if (requestDelayMillis > 0) delay(requestDelayMillis)
            return SMangaUpdate(
                manga = remoteManga,
                chapters = remoteChapters,
            )
        }
    }

    private companion object {
        const val READING_LIST_ID = 1L

        fun remoteManga(url: String, title: String): SManga {
            return SManga.create().apply {
                this.url = url
                this.title = title
            }
        }

        fun remoteChapter(url: String, name: String, number: Float): SChapter {
            return SChapter.create().apply {
                this.url = url
                this.name = name
                this.chapter_number = number
            }
        }
    }
}
