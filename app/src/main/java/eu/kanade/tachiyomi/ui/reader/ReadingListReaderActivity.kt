package eu.kanade.tachiyomi.ui.reader

/**
 * Uses the normal reader implementation with a fresh activity instance for every reading-list entry.
 * This keeps each chapter loader scoped to exactly one manga/source while ordinary ReaderActivity
 * keeps its existing single-task behavior.
 */
class ReadingListReaderActivity : ReaderActivity()
