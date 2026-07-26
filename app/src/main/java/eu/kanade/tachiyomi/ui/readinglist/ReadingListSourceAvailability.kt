package eu.kanade.tachiyomi.ui.readinglist

import android.app.Application
import android.content.pm.PackageManager
import eu.kanade.tachiyomi.extension.ExtensionManager
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Checks the Android package state of the exact extension that owns a saved source ID.
 *
 * A disabled package remains installed and may still have sources registered in memory, so source-manager
 * presence alone is not sufficient for a reading-list entry to be considered readable.
 */
internal fun interface ReadingListSourceAvailability {
    fun isAvailable(sourceId: Long): Boolean
}

internal class InstalledExtensionSourceAvailability(
    private val application: Application = Injekt.get(),
    private val extensionManager: ExtensionManager = Injekt.get(),
) : ReadingListSourceAvailability {

    override fun isAvailable(sourceId: Long): Boolean {
        val packageName = extensionManager.getExtensionPackage(sourceId) ?: return false
        val packageManager = application.packageManager
        val applicationInfo = try {
            @Suppress("DEPRECATION")
            packageManager.getApplicationInfo(packageName, PackageManager.MATCH_DISABLED_COMPONENTS)
        } catch (_: PackageManager.NameNotFoundException) {
            return false
        }

        return when (
            try {
                packageManager.getApplicationEnabledSetting(packageName)
            } catch (_: IllegalArgumentException) {
                return false
            }
        ) {
            PackageManager.COMPONENT_ENABLED_STATE_DEFAULT -> applicationInfo.enabled
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED -> true
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED,
            -> false
            else -> false
        }
    }
}
