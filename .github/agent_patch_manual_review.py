from pathlib import Path


def replace_once(path: str, old: str, new: str) -> None:
    file = Path(path)
    text = file.read_text(encoding="utf-8")
    if new in text:
        return
    if old not in text:
        raise RuntimeError(f"Expected patch context not found in {path}: {old[:80]!r}")
    file.write_text(text.replace(old, new, 1), encoding="utf-8")


TAB = "app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListsTab.kt"
REVIEW = "app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListReviewScreen.kt"
MODEL = "app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListReviewScreenModel.kt"

replace_once(
    TAB,
    "import cafe.adriel.voyager.navigator.Navigator\n",
    "import cafe.adriel.voyager.navigator.LocalNavigator\n"
    "import cafe.adriel.voyager.navigator.Navigator\n"
    "import cafe.adriel.voyager.navigator.currentOrThrow\n",
)
replace_once(
    TAB,
    "        val context = LocalContext.current\n        val screenModel = rememberScreenModel { ReadingListsScreenModel() }\n",
    "        val context = LocalContext.current\n"
    "        val navigator = LocalNavigator.currentOrThrow\n"
    "        val screenModel = rememberScreenModel { ReadingListsScreenModel() }\n",
)
replace_once(
    TAB,
    "            onImport = launchImport,\n            onSearch = screenModel::searchCandidates,\n",
    "            onImport = launchImport,\n"
    "            onReview = { readingListId -> navigator.push(ReadingListReviewScreen(readingListId)) },\n"
    "            onSearch = screenModel::searchCandidates,\n",
)
replace_once(
    TAB,
    "    onImport: () -> Unit,\n    onSearch: (Long) -> Unit,\n",
    "    onImport: () -> Unit,\n    onReview: (Long) -> Unit,\n    onSearch: (Long) -> Unit,\n",
)
replace_once(
    TAB,
    "                contentPadding = paddingValues,\n                onSearch = onSearch,\n",
    "                contentPadding = paddingValues,\n"
    "                onReview = onReview,\n"
    "                onSearch = onSearch,\n",
)
replace_once(
    TAB,
    "    contentPadding: PaddingValues,\n    onSearch: (Long) -> Unit,\n",
    "    contentPadding: PaddingValues,\n    onReview: (Long) -> Unit,\n    onSearch: (Long) -> Unit,\n",
)
replace_once(
    TAB,
    "                isSearching = readingList.id in searchingReadingListIds,\n                onSearch = { onSearch(readingList.id) },\n",
    "                isSearching = readingList.id in searchingReadingListIds,\n"
    "                onReview = { onReview(readingList.id) },\n"
    "                onSearch = { onSearch(readingList.id) },\n",
)
replace_once(
    TAB,
    "    isSearching: Boolean,\n    onSearch: () -> Unit,\n",
    "    isSearching: Boolean,\n    onReview: () -> Unit,\n    onSearch: () -> Unit,\n",
)
replace_once(
    TAB,
    "        modifier = Modifier.clickable(enabled = !isSearching, onClick = onEditSources),\n",
    "        modifier = Modifier.clickable(enabled = !isSearching, onClick = onReview),\n",
)
replace_once(
    TAB,
    "            Row {\n                IconButton(\n                    onClick = onSearch,\n",
    "            Row {\n"
    "                IconButton(\n"
    "                    onClick = onReview,\n"
    "                    enabled = !isSearching,\n"
    "                ) {\n"
    "                    Icon(\n"
    "                        imageVector = Icons.Outlined.List,\n"
    "                        contentDescription = stringResource(R.string.reading_list_review),\n"
    "                    )\n"
    "                }\n"
    "                IconButton(\n"
    "                    onClick = onSearch,\n",
)

replace_once(REVIEW, "import androidx.compose.foundation.layout.Spacer\n", "")
replace_once(REVIEW, "import androidx.compose.foundation.layout.size\n", "")
replace_once(REVIEW, "import androidx.compose.foundation.layout.width\n", "import androidx.compose.foundation.layout.weight\n")
replace_once(REVIEW, "import androidx.compose.material3.CircularProgressIndicator\n", "")
replace_once(
    REVIEW,
    "import androidx.compose.ui.Modifier\n",
    "import androidx.compose.ui.Modifier\nimport androidx.compose.ui.platform.LocalContext\n",
)
replace_once(
    REVIEW,
    "        val navigator = LocalNavigator.currentOrThrow\n        val screenModel = rememberScreenModel { ReadingListReviewScreenModel(readingListId) }\n",
    "        val navigator = LocalNavigator.currentOrThrow\n"
    "        val context = LocalContext.current\n"
    "        val screenModel = rememberScreenModel { ReadingListReviewScreenModel(readingListId) }\n",
)
replace_once(REVIEW, "resourceId -> navigator.context.getString(resourceId)", "resourceId -> context.getString(resourceId)")
replace_once(
    REVIEW,
    '''                    Text(\n                        text = buildString {\n                            append(stringResource(entry.resolutionState.labelRes))\n                            if (entry.userConfirmed) append(" • ").append(stringResource(R.string.reading_list_review_user_confirmed))\n                            if (entry.skipped) append(" • ").append(stringResource(R.string.reading_list_review_skipped))\n                            append(" • ").append(\n                                stringResource(\n                                    R.string.reading_list_review_candidate_count,\n                                    item.candidates.size,\n                                ),\n                            )\n                        },\n''',
    '''                    val statusParts = mutableListOf(stringResource(entry.resolutionState.labelRes))\n                    if (entry.userConfirmed) {\n                        statusParts += stringResource(R.string.reading_list_review_user_confirmed)\n                    }\n                    if (entry.skipped) {\n                        statusParts += stringResource(R.string.reading_list_review_skipped)\n                    }\n                    statusParts += stringResource(\n                        R.string.reading_list_review_candidate_count,\n                        item.candidates.size,\n                    )\n                    Text(\n                        text = statusParts.joinToString(" • "),\n''',
)
replace_once(
    REVIEW,
    "entry.extraElements.values.sumOf(List<String>::size)",
    "entry.extraElements.values.sumOf { values -> values.size }",
)
replace_once(
    REVIEW,
    '''    val conflicts = buildList {\n        if (!breakdown.issueEquivalent) add(stringResource(R.string.reading_list_review_conflict_issue))\n        if (breakdown.titleSimilarity < 0.85) add(stringResource(R.string.reading_list_review_conflict_title))\n        if (breakdown.yearEvidence == EvidenceAgreement.MISMATCH) add(stringResource(R.string.reading_list_review_conflict_year))\n        if (breakdown.volumeEvidence == EvidenceAgreement.MISMATCH) add(stringResource(R.string.reading_list_review_conflict_volume))\n        if (breakdown.externalIdentifierEvidence == EvidenceAgreement.MISMATCH) {\n            add(stringResource(R.string.reading_list_review_conflict_identifier))\n        }\n    }\n''',
    '''    val conflicts = mutableListOf<String>()\n    if (!breakdown.issueEquivalent) conflicts += stringResource(R.string.reading_list_review_conflict_issue)\n    if (breakdown.titleSimilarity < 0.85) conflicts += stringResource(R.string.reading_list_review_conflict_title)\n    if (breakdown.yearEvidence == EvidenceAgreement.MISMATCH) {\n        conflicts += stringResource(R.string.reading_list_review_conflict_year)\n    }\n    if (breakdown.volumeEvidence == EvidenceAgreement.MISMATCH) {\n        conflicts += stringResource(R.string.reading_list_review_conflict_volume)\n    }\n    if (breakdown.externalIdentifierEvidence == EvidenceAgreement.MISMATCH) {\n        conflicts += stringResource(R.string.reading_list_review_conflict_identifier)\n    }\n''',
)

replace_once(
    MODEL,
    '''val ReadingListEntry.needsManualAttention: Boolean\n    get() = when (resolutionState) {\n''',
    '''val ReadingListEntry.needsManualAttention: Boolean\n    get() {\n        if (userConfirmed || skipped) return false\n        return when (resolutionState) {\n''',
)
replace_once(
    MODEL,
    '''        ReadingListEntryResolutionState.USER_CONFIRMED,\n        -> false\n    }\n\nsealed interface ReadingListReviewAction {\n''',
    '''        ReadingListEntryResolutionState.USER_CONFIRMED,\n        -> false\n        }\n    }\n\nsealed interface ReadingListReviewAction {\n''',
)
