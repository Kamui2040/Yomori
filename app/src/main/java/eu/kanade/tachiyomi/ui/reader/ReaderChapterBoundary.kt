package eu.kanade.tachiyomi.ui.reader

/** A viewer transition that has no adjacent chapter in the active manga-scoped reader list. */
enum class ReaderChapterBoundary {
    PREVIOUS,
    NEXT,
}
