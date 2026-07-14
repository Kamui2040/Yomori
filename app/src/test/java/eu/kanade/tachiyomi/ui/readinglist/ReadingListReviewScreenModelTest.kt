package eu.kanade.tachiyomi.ui.readinglist

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import tachiyomi.domain.readinglist.matching.ConfirmedHistoryEvidence
import tachiyomi.domain.readinglist.matching.EvidenceAgreement
import tachiyomi.domain.readinglist.matching.MatchDecisionReason
import tachiyomi.domain.readinglist.matching.MatchScoreBreakdown
import tachiyomi.domain.readinglist.matching.ReadingListSeriesKey
import tachiyomi.domain.readinglist.matching.SourcePreferenceLevel
import tachiyomi.domain.readinglist.model.ReadingList
import tachiyomi.domain.readinglist.model.ReadingListCandidateIdentity
import tachiyomi.domain.readinglist.model.ReadingListCandidateRejection
import tachiyomi.domain.readinglist.model.ReadingListEntry
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.model.ReadingListMatchCandidateSnapshot
import tachiyomi.domain.readinglist.model.ReadingListResolutionData
import tachiyomi.domain.readinglist.model.ReadingListSeriesMapping
import tachiyomi.domain.readinglist.model.ReadingListSeriesMappingUpdate
import tachiyomi.domain.readinglist.model.ReadingListStoredMatchCandidate
import tachiyomi.domain.readinglist.repository.ReadingListResolutionRepository

@Execution(ExecutionMode.CONCURRENT)
class ReadingListReviewScreenModelTest {

    @Test
    fun `presentation preserves cbl order candidate order and orphaned rejections`() {
        val firstCandidate = storedCandidate(entryId = 10, candidateId = "first", score = 79.0)
        val secondCandidate = storedCandidate(entryId = 10, candidateId = "second", score = 71.0)
        val orphanIdentity = ReadingListCandidateIdentity(sourceId = 9, candidateId = "removed")
        val readingList = readingList(
            entries = listOf(
                entry(id = 12, position = 2, number = "3"),
                entry(id = 10, position = 0, number = "1"),
                entry(id = 11, position = 1, number = "2"),
            ),
        )
        val seriesKey = ReadingListSeriesKey.from("Example")
        val resolution = ReadingListResolutionData(
            readingListId = readingList.id,
            candidates = listOf(firstCandidate, secondCandidate),
            rejections = listOf(
                ReadingListCandidateRejection(
                    entryId = 10,
                    identity = secondCandidate.snapshot.identity,
                    mangaUrl = secondCandidate.snapshot.mangaUrl,
                    chapterUrl = secondCandidate.snapshot.chapterUrl,
                    rejectedAt = 1,
                ),
                ReadingListCandidateRejection(
                    entryId = 10,
                    identity = orphanIdentity,
                    mangaUrl = "/series/removed",
                    chapterUrl = "/chapter/removed",
                    rejectedAt = 2,
                ),
            ),
            entryOverrides = emptyList(),
            seriesMappings = listOf(
                ReadingListSeriesMapping(
                    readingListId = readingList.id,
                    seriesKey = seriesKey,
                    seriesTitle = "Example",
                    sourceId = 7,
                    mangaUrl = "/series/first",
                    userConfirmed = true,
                    createdAt = 1,
                    updatedAt = 1,
                ),
            ),
        )

        val review = buildReadingListReviewData(readingList, resolution)

        review.entries.map { item -> item.entry.id } shouldContainExactly listOf(10L, 11L, 12L)
        review.entries.first().candidates.map { candidate ->
            candidate.snapshot.identity.candidateId
        } shouldContainExactly
            listOf("first", "second")
        review.entries.first().orphanRejections.map { rejection -> rejection.identity } shouldContainExactly
            listOf(orphanIdentity)
        review.entries.first().seriesMapping?.seriesKey shouldBe seriesKey
    }

    @Test
    fun `candidate confirmation uses the exact persisted snapshot`() = runTest {
        val repository = mockk<ReadingListResolutionRepository>()
        val candidate = storedCandidate(entryId = 10, candidateId = "exact", score = 76.0)
        val review = reviewData(candidate)
        coEvery { repository.confirmResolution(10, candidate.snapshot) } returns true

        val applied = ReadingListReviewOperations(repository).confirmCandidate(
            review = review,
            entryId = 10,
            identity = candidate.snapshot.identity,
        )

        applied shouldBe true
        coVerify(exactly = 1) { repository.confirmResolution(10, candidate.snapshot) }
    }

    @Test
    fun `series mapping is a separate explicit operation`() = runTest {
        val repository = mockk<ReadingListResolutionRepository>()
        val candidate = storedCandidate(entryId = 10, candidateId = "series", score = 80.0)
        val review = reviewData(candidate)
        val expected = ReadingListSeriesMappingUpdate(
            seriesKey = ReadingListSeriesKey.from("Example"),
            seriesTitle = "Example",
            sourceId = candidate.snapshot.identity.sourceId,
            mangaUrl = candidate.snapshot.mangaUrl,
        )
        coEvery { repository.confirmSeriesMapping(review.readingList.id, expected) } returns true

        val applied = ReadingListReviewOperations(repository).confirmSeriesMapping(
            review = review,
            entryId = 10,
            identity = candidate.snapshot.identity,
        )

        applied shouldBe true
        coVerify(exactly = 1) { repository.confirmSeriesMapping(review.readingList.id, expected) }
        coVerify(exactly = 0) { repository.confirmResolution(any(), any()) }
    }

    @Test
    fun `orphaned rejection can be restored without a candidate snapshot`() = runTest {
        val repository = mockk<ReadingListResolutionRepository>()
        val orphanIdentity = ReadingListCandidateIdentity(sourceId = 9, candidateId = "removed")
        val readingList = readingList(entries = listOf(entry(id = 10, position = 0, number = "1")))
        val review = buildReadingListReviewData(
            readingList = readingList,
            resolution = ReadingListResolutionData(
                readingListId = readingList.id,
                candidates = emptyList(),
                rejections = listOf(
                    ReadingListCandidateRejection(
                        entryId = 10,
                        identity = orphanIdentity,
                        mangaUrl = "/series/removed",
                        chapterUrl = "/chapter/removed",
                        rejectedAt = 1,
                    ),
                ),
                entryOverrides = emptyList(),
                seriesMappings = emptyList(),
            ),
        )
        coEvery { repository.clearCandidateRejection(10, orphanIdentity) } returns true

        val applied = ReadingListReviewOperations(repository).restoreCandidate(
            review = review,
            entryId = 10,
            identity = orphanIdentity,
        )

        applied shouldBe true
        coVerify(exactly = 1) { repository.clearCandidateRejection(10, orphanIdentity) }
    }

    private fun reviewData(candidate: ReadingListStoredMatchCandidate): ReadingListReviewData {
        val readingList = readingList(entries = listOf(entry(id = 10, position = 0, number = "1")))
        return buildReadingListReviewData(
            readingList = readingList,
            resolution = ReadingListResolutionData(
                readingListId = readingList.id,
                candidates = listOf(candidate),
                rejections = emptyList(),
                entryOverrides = emptyList(),
                seriesMappings = emptyList(),
            ),
        )
    }

    private fun readingList(entries: List<ReadingListEntry>): ReadingList {
        return ReadingList(
            id = 1,
            name = "Fixture",
            description = null,
            declaredIssueCount = entries.size,
            entries = entries,
            selectedSourceIds = listOf(7),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            warnings = emptyList(),
            currentPosition = null,
            createdAt = 1,
            updatedAt = 1,
        )
    }

    private fun entry(
        id: Long,
        position: Int,
        number: String,
    ): ReadingListEntry {
        return ReadingListEntry(
            id = id,
            readingListId = 1,
            position = position,
            series = "Example",
            number = number,
            volume = null,
            year = null,
            databases = emptyList(),
            extraAttributes = emptyMap(),
            extraElements = emptyMap(),
            resolutionState = ReadingListEntryResolutionState.AMBIGUOUS,
            matchedSourceId = null,
            matchedMangaUrl = null,
            matchedChapterUrl = null,
            confidence = null,
            matcherVersion = 1,
            userConfirmed = false,
            skipped = false,
        )
    }

    private fun storedCandidate(
        entryId: Long,
        candidateId: String,
        score: Double,
    ): ReadingListStoredMatchCandidate {
        return ReadingListStoredMatchCandidate(
            entryId = entryId,
            snapshot = ReadingListMatchCandidateSnapshot(
                identity = ReadingListCandidateIdentity(
                    sourceId = 7,
                    candidateId = candidateId,
                ),
                sourceName = "Fixture source",
                sourceLanguage = "en",
                mangaUrl = "/series/$candidateId",
                chapterUrl = "/chapter/$candidateId",
                seriesTitle = "Example",
                issueNumber = "1",
                volume = null,
                year = null,
                breakdown = MatchScoreBreakdown(
                    titleSimilarity = 1.0,
                    titlePoints = 58.0,
                    issueEquivalent = true,
                    issuePoints = 30.0,
                    yearEvidence = EvidenceAgreement.UNKNOWN,
                    yearPoints = 0.0,
                    volumeEvidence = EvidenceAgreement.UNKNOWN,
                    volumePoints = 0.0,
                    externalIdentifierEvidence = EvidenceAgreement.UNKNOWN,
                    externalIdentifierPoints = 0.0,
                    sourcePreference = SourcePreferenceLevel.READING_LIST,
                    sourcePreferencePoints = 1.0,
                    confirmedHistory = ConfirmedHistoryEvidence.NONE,
                    confirmedHistoryPoints = 0.0,
                    total = score,
                ),
                decisionReason = MatchDecisionReason.BELOW_AUTO_THRESHOLD,
                leadOverRunnerUp = 8.0,
                matcherVersion = 1,
            ),
            rejected = false,
            createdAt = 1,
            updatedAt = 1,
        )
    }
}
