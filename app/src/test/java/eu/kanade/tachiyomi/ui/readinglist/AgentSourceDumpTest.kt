package eu.kanade.tachiyomi.ui.readinglist

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class AgentSourceDumpTest {

    @Test
    fun `package public matching sources for exact qa correction`() {
        val root = generateSequence(Path.of("").toAbsolutePath()) { path -> path.parent }
            .first { path -> Files.exists(path.resolve("settings.gradle.kts")) }
        val files = listOf(
            "app/src/main/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListCandidateSearch.kt",
            "domain/src/main/java/tachiyomi/domain/readinglist/matching/ReadingListMatchScorer.kt",
            "domain/src/main/java/tachiyomi/domain/readinglist/normalization/TitleNormalizer.kt",
            "domain/src/test/java/tachiyomi/domain/readinglist/matching/ReadingListMatchScorerTest.kt",
            "app/src/test/java/eu/kanade/tachiyomi/ui/readinglist/ReadingListCandidateSearchTest.kt",
        )
        val output = root.resolve("app/src/main/assets/agent-source-dump.zip")
        Files.createDirectories(output.parent)
        ZipOutputStream(Files.newOutputStream(output)).use { zip ->
            files.forEach { relativePath ->
                zip.putNextEntry(ZipEntry(relativePath))
                Files.copy(root.resolve(relativePath), zip)
                zip.closeEntry()
            }
        }
    }
}
