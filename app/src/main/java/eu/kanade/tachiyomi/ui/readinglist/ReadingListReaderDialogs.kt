package eu.kanade.tachiyomi.ui.readinglist

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import eu.kanade.tachiyomi.R
import tachiyomi.domain.readinglist.model.ReadingListSummary

@Composable
fun ReadingListReaderRestartDialog(
    readingList: ReadingListSummary,
    onRestart: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.reading_list_reader_restart_title)) },
        text = {
            Text(
                stringResource(
                    R.string.reading_list_reader_restart_message,
                    readingList.name ?: stringResource(R.string.reading_list_untitled),
                ),
            )
        },
        confirmButton = {
            TextButton(onClick = onRestart) {
                Text(stringResource(R.string.reading_list_reader_restart))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.reading_list_cancel_action))
            }
        },
    )
}

@Composable
fun ReadingListReaderBlockedDialog(
    entry: ReadingListReaderBlockedEntry,
    onReview: () -> Unit,
    onSkip: () -> Unit,
    onStop: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onStop,
        title = { Text(stringResource(R.string.reading_list_reader_blocked_title)) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    stringResource(
                        R.string.reading_list_reader_blocked_entry,
                        entry.position + 1,
                        entry.entryCount,
                        entry.series,
                        entry.issueNumber,
                    ),
                )
                Text(stringResource(entry.reason.stringRes))
            }
        },
        confirmButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                TextButton(onClick = onReview) {
                    Text(stringResource(R.string.reading_list_reader_review))
                }
                TextButton(onClick = onSkip) {
                    Text(stringResource(R.string.reading_list_reader_skip))
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onStop) {
                Text(stringResource(R.string.reading_list_reader_stop))
            }
        },
    )
}

@get:StringRes
val ReadingListReaderBlockReason.stringRes: Int
    get() = when (this) {
        ReadingListReaderBlockReason.UNSEARCHED -> R.string.reading_list_reader_reason_unsearched
        ReadingListReaderBlockReason.SEARCHING -> R.string.reading_list_reader_reason_searching
        ReadingListReaderBlockReason.AMBIGUOUS -> R.string.reading_list_reader_reason_ambiguous
        ReadingListReaderBlockReason.UNRESOLVED -> R.string.reading_list_reader_reason_unresolved
        ReadingListReaderBlockReason.SOURCE_UNAVAILABLE -> R.string.reading_list_reader_reason_source_unavailable
        ReadingListReaderBlockReason.CHAPTER_REMOVED -> R.string.reading_list_reader_reason_chapter_removed
        ReadingListReaderBlockReason.NEEDS_REMATCH -> R.string.reading_list_reader_reason_needs_rematch
        ReadingListReaderBlockReason.SKIPPED -> R.string.reading_list_reader_reason_skipped
        ReadingListReaderBlockReason.MISSING_MATCH_IDENTITY -> R.string.reading_list_reader_reason_missing_identity
        ReadingListReaderBlockReason.SOURCE_NOT_SELECTED -> R.string.reading_list_reader_reason_source_not_selected
        ReadingListReaderBlockReason.SOURCE_REQUEST_FAILED -> R.string.reading_list_reader_reason_source_failed
        ReadingListReaderBlockReason.MATERIALIZATION_FAILED ->
            R.string.reading_list_reader_reason_materialization_failed
    }
