package eu.kanade.tachiyomi.ui.reader

internal fun Throwable.toReaderErrorMessage(
    isHttpSource: Boolean,
    sourceExtensionMessage: String,
    fallbackMessage: String,
): String {
    val causes = generateSequence(this) { it.cause }
    val hasNullPointerFailure = causes.any { throwable ->
        throwable is NullPointerException ||
            throwable.message.orEmpty().contains("NullPointerException", ignoreCase = true)
    }

    if (isHttpSource && hasNullPointerFailure) {
        return sourceExtensionMessage
    }

    return message?.takeIf(String::isNotBlank) ?: fallbackMessage
}
