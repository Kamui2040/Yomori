package eu.kanade.tachiyomi.ui.readinglist

import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.Test
import tachiyomi.domain.readinglist.matching.ConfirmedHistoryEvidence
import tachiyomi.domain.readinglist.matching.EvidenceAgreement
import tachiyomi.domain.readinglist.matching.MatchDecisionReason
import tachiyomi.domain.readinglist.matching.MatchScoreBreakdown
import tachiyomi.domain.readinglist.matching.SourcePreferenceLevel
import tachiyomi.domain.readinglist.model.ReadingListCandidateIdentity
import tachiyomi.domain.readinglist.model.ReadingListEntry
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.model.ReadingListMatchCandidateSnapshot
import tachiyomi.domain.readinglist.model.ReadingListStoredMatchCandidate

class ReadingListReviewCandidateOrderingTest {

    @Test
    fun `active confirmed candidate is surfaced before higher scoring alternatives`() {
        val alternative = candidate(
            sourceId = 1L,
            candidateId = "alternative",
            mangaUrl = "/series/alternative",
            chapterUrl = "/chapter/alternative",
            score = 98.0,
        )
        val confirmed = candidate(
            sourceId = 2L,
            candidateId = "confirmed",
            mangaUrl = "/series/confirmed",
            chapterUrl = "/chapter/confirmed",
            score = 89.0,
        )
        val entry = entry(
            matchedSourceId = confirmed.snapshot.identity.sourceId,
            matchedMangaUrl = confirmed.snapshot.mangaUrl,
            matchedChapterUrl = confirmed.snapshot.chapterUrl,
        )

        orderReadingListReviewCandidates(entry, listOf(alternative, confirmed))
            .map { it.snapshot.identity.candidateId }
            .shouldContainExactly("confirmed", "alternative")
    }

    @Test
    fun `candidate order is unchanged when no active identity matches`() {
        val first = candidate(1L, "first", "/series/first", "/chapter/first", 90.0)
        val second = candidate(2L, "second", "/series/second", "/chapter/second", 80.0)

        orderReadingListReviewCandidates(entry(), listOf(first, second))
            .map { it.snapshot.identity.candidateId }
            .shouldContainExactly("first", "second")
    }

    private fun entry(
        matchedSourceId: Long? = null,
        matchedMangaUrl: String? = null,
        matchedChapterUrl: String? = null,
    ): ReadingListEntry {
        return ReadingListEntry(
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
            matchedSourceId = matchedSourceId,
            matchedMangaUrl = matchedMangaUrl,
            matchedChapterUrl = matchedChapterUrl,
            confidence = 100.0,
            matcherVersion = 1,
            userConfirmed = true,
            skipped = false,
        )
    }

    private fun candidate(
        sourceId: Long,
        candidateId: String,
        mangaUrl: String,
        chapterUrl: String,
        score: Double,
    ): ReadingListStoredMatchCandidate {
        return ReadingListStoredMatchCandidate(
            entryId = ENTRY_ID,
            snapshot = ReadingListMatchCandidateSnapshot(
                identity = ReadingListCandidateIdentity(sourceId, candidateId),
                sourceName = "Source $sourceId",
                sourceLanguage = "en",
                mangaUrl = mangaUrl,
                chapterUrl = chapterUrl,
                seriesTitle = "Series",
                issueNumber = "1",
                volume = null,
                year = null,
                breakdown = MatchScoreBreakdown(
                    titleSimilarity = 1.0,
                    titlePoints = score,
                    issueEquivalent = true,
                    issuePoints = 0.0,
                    yearEvidence = EvidenceAgreement.UNKNOWN,
                    yearPoints = 0.0,
                    volumeEvidence = EvidenceAgreement.UNKNOWN,
                    volumePoints = 0.0,
                    externalIdentifierEvidence = EvidenceAgreement.UNKNOWN,
                    externalIdentifierPoints = 0.0,
                    sourcePreference = SourcePreferenceLevel.NONE,
                    sourcePreferencePoints = 0.0,
                    confirmedHistory = ConfirmedHistoryEvidence.NONE,
                    confirmedHistoryPoints = 0.0,
                    total = score,
                ),
                decisionReason = MatchDecisionReason.USER_CONFIRMED,
                leadOverRunnerUp = null,
                matcherVersion = 1,
            ),
            rejected = false,
            createdAt = 1L,
            updatedAt = 1L,
        )
    }

    private companion object {
        const val READING_LIST_ID = 1L
        const val ENTRY_ID = 10L
    }
}
