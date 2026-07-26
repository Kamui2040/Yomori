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
    fun `default package state accepts a manifest enabled exact extension`() {
        val fixture = fixture(
            manifestEnabled = true,
            enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
        )

        fixture.availability.isAvailable(SOURCE_ID) shouldBe true
    }

    @Test
    fun `default package state rejects a manifest disabled exact extension`() {
        val fixture = fixture(
            manifestEnabled = false,
            enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
        )

        fixture.availability.isAvailable(SOURCE_ID) shouldBe false
    }

    @Test
    fun `explicit enabled state overrides a manifest disabled exact extension`() {
        val fixture = fixture(
            manifestEnabled = false,
            enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        )

        fixture.availability.isAvailable(SOURCE_ID) shouldBe true
    }

    @Test
    fun `Android disabled states reject a manifest enabled exact extension`() {
        val disabledStates = listOf(
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED,
        )

        disabledStates.forEach { enabledSetting ->
            fixture(
                manifestEnabled = true,
                enabledSetting = enabledSetting,
            ).availability.isAvailable(SOURCE_ID) shouldBe false
        }
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

    @Test
    fun `removed Android package is unavailable`() {
        val application = mockk<Application>()
        val packageManager = mockk<PackageManager>()
        val extensionManager = mockk<ExtensionManager>()

        every { application.packageManager } returns packageManager
        every { extensionManager.getExtensionPackage(SOURCE_ID) } returns EXTENSION_PACKAGE
        @Suppress("DEPRECATION")
        every {
            packageManager.getApplicationInfo(
                EXTENSION_PACKAGE,
                PackageManager.MATCH_DISABLED_COMPONENTS,
            )
        } throws PackageManager.NameNotFoundException()

        InstalledExtensionSourceAvailability(
            application = application,
            extensionManager = extensionManager,
        ).isAvailable(SOURCE_ID) shouldBe false
    }

    @Test
    fun `missing enabled setting package is unavailable`() {
        val fixture = fixture(
            manifestEnabled = true,
            enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
        )
        every {
            fixture.packageManager.getApplicationEnabledSetting(EXTENSION_PACKAGE)
        } throws IllegalArgumentException()

        fixture.availability.isAvailable(SOURCE_ID) shouldBe false
    }

    @Test
    fun `unknown enabled state is unavailable`() {
        val fixture = fixture(
            manifestEnabled = true,
            enabledSetting = Int.MAX_VALUE,
        )

        fixture.availability.isAvailable(SOURCE_ID) shouldBe false
    }

    private fun fixture(
        manifestEnabled: Boolean,
        enabledSetting: Int,
    ): Fixture {
        val application = mockk<Application>()
        val packageManager = mockk<PackageManager>()
        val extensionManager = mockk<ExtensionManager>()
        val applicationInfo = ApplicationInfo().apply { enabled = manifestEnabled }

        every { application.packageManager } returns packageManager
        every { extensionManager.getExtensionPackage(SOURCE_ID) } returns EXTENSION_PACKAGE
        @Suppress("DEPRECATION")
        every {
            packageManager.getApplicationInfo(
                EXTENSION_PACKAGE,
                PackageManager.MATCH_DISABLED_COMPONENTS,
            )
        } returns applicationInfo
        every {
            packageManager.getApplicationEnabledSetting(EXTENSION_PACKAGE)
        } returns enabledSetting

        return Fixture(
            availability = InstalledExtensionSourceAvailability(
                application = application,
                extensionManager = extensionManager,
            ),
            packageManager = packageManager,
        )
    }

    private data class Fixture(
        val availability: InstalledExtensionSourceAvailability,
        val packageManager: PackageManager,
    )

    private companion object {
        const val SOURCE_ID = 42L
        const val EXTENSION_PACKAGE = "example.extension"
    }
}
