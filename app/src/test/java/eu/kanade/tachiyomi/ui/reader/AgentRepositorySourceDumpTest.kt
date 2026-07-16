package eu.kanade.tachiyomi.ui.reader

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class AgentRepositorySourceDumpTest {

    @Test
    fun `package repository sources for cross-series implementation`() {
        val root = generateSequence(Path.of("").toAbsolutePath()) { path -> path.parent }
            .first { path -> Files.exists(path.resolve("settings.gradle.kts")) }
        val output = root.resolve("app/src/main/assets/agent-repository-source.zip")
        Files.createDirectories(output.parent)

        val extensions = setOf("kt", "kts", "sq", "sqm", "xml", "toml", "md", "properties")
        val excludedSegments = setOf(".git", ".gradle", "build", ".idea")

        ZipOutputStream(Files.newOutputStream(output)).use { zip ->
            Files.walk(root).use { paths ->
                paths
                    .filter(Files::isRegularFile)
                    .filter { path -> path != output }
                    .filter { path -> root.relativize(path).none { segment -> segment.toString() in excludedSegments } }
                    .filter { path -> path.fileName.toString().substringAfterLast('.', "") in extensions }
                    .sorted()
                    .forEach { path ->
                        val relative = root.relativize(path).toString().replace('\\', '/')
                        zip.putNextEntry(ZipEntry(relative))
                        Files.copy(path, zip)
                        zip.closeEntry()
                    }
            }
        }
    }
}
