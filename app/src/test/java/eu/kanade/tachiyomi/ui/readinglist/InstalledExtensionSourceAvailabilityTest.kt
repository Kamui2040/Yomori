package eu.kanade.tachiyomi.ui.readinglist

import android.app.Application
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import eu.kanade.tachiyomi.extension.ExtensionManager
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class InstalledExtensionSourceAvailabilityTest {

    @Test
    fun `registered application package manager accepts an enabled exact extension`() {
        val fixture = fixture(enabled = true)

        fixture.availability.isAvailable(SOURCE_ID) shouldBe true
    }

    @Test
    fun `registered application package manager rejects a disabled exact extension`() {
        val fixture = fixture(enabled = false)

        fixture.availability.isAvailable(SOURCE_ID) shouldBe false
    }

    @Test
    fun `missing exact extension package is unavailable`() {
        val application = mockk<Application>()
        val extensionManager = mockk<ExtensionManager>()
        every { extensionManager.getExtensionPackage(SOURCE_ID) } returns null

        InstalledExtensionSourceAvailability(
            application = application,
            extensionManager = extensionManager,
        ).isAvailable(SOURCE_ID) shouldBe false
    }

    private fun fixture(enabled: Boolean): Fixture {
        val application = mockk<Application>()
        val packageManager = mockk<PackageManager>()
        val extensionManager = mockk<ExtensionManager>()
        val applicationInfo = ApplicationInfo().apply { this.enabled = enabled }

        every { application.packageManager } returns packageManager
        every { extensionManager.getExtensionPackage(SOURCE_ID) } returns EXTENSION_PACKAGE
        @Suppress("DEPRECATION")
        every {
            packageManager.getApplicationInfo(
                EXTENSION_PACKAGE,
                PackageManager.MATCH_DISABLED_COMPONENTS,
            )
        } returns applicationInfo

        return Fixture(
            availability = InstalledExtensionSourceAvailability(
                application = application,
                extensionManager = extensionManager,
            ),
        )
    }

    private data class Fixture(
        val availability: InstalledExtensionSourceAvailability,
    )

    private companion object {
        const val SOURCE_ID = 42L
        const val EXTENSION_PACKAGE = "example.extension"
    }
}
