package eu.kanade.tachiyomi.ui.readinglist

import android.content.Context
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
    private val context: Context = Injekt.get(),
    private val extensionManager: ExtensionManager = Injekt.get(),
) : ReadingListSourceAvailability {

    override fun isAvailable(sourceId: Long): Boolean {
        val packageName = extensionManager.getExtensionPackage(sourceId) ?: return false
        return try {
            @Suppress("DEPRECATION")
            context.packageManager
                .getApplicationInfo(packageName, PackageManager.MATCH_DISABLED_COMPONENTS)
                .enabled
        } catch (_: PackageManager.NameNotFoundException) {
            false
        }
    }
}
