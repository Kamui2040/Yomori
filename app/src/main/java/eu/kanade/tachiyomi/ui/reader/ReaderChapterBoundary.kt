package eu.kanade.tachiyomi.ui.reader

/**
 * A viewer transition with no adjacent chapter in the active manga-scoped reader list.
 * Ordinary reader sessions keep their existing boundary behavior; list sessions may continue by CBL order.
 */
enum class ReaderChapterBoundary {
    PREVIOUS,
    NEXT,
}
