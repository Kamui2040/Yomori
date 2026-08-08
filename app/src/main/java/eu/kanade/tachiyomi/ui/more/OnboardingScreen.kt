package eu.kanade.tachiyomi.ui.more

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import eu.kanade.domain.base.BasePreferences
import eu.kanade.presentation.more.onboarding.OnboardingScreen
import eu.kanade.presentation.more.settings.screen.SearchableSettings
import eu.kanade.presentation.more.settings.screen.SettingsDataScreen
import eu.kanade.presentation.util.Screen
import eu.kanade.tachiyomi.ui.setting.SettingsScreen
import tachiyomi.presentation.core.i18n.stringResource
import tachiyomi.presentation.core.util.collectAsState
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

class OnboardingScreen : Screen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val context = LocalContext.current

        val basePreferences = remember { Injekt.get<BasePreferences>() }
        val shownYomoriWelcome by basePreferences.shownYomoriWelcome.collectAsState()
        val shownOnboardingFlow by basePreferences.shownOnboardingFlow.collectAsState()

        val finishWelcome: () -> Unit = {
            basePreferences.shownYomoriWelcome.set(true)
            if (shownOnboardingFlow) {
                navigator.pop()
            }
        }

        val finishOnboarding: () -> Unit = {
            basePreferences.shownOnboardingFlow.set(true)
            navigator.pop()
        }

        val restoreSettingKey = stringResource(SettingsDataScreen.restorePreferenceKeyString)

        BackHandler(enabled = !shownYomoriWelcome || !shownOnboardingFlow) {
            // Mandatory welcome and incomplete onboarding cannot be bypassed with Back.
        }

        OnboardingScreen(
            showWelcome = !shownYomoriWelcome,
            onWelcomeComplete = finishWelcome,
            onComplete = finishOnboarding,
            onExit = {
                context.findActivity()?.finishAndRemoveTask()
            },
            onRestoreBackup = {
                finishOnboarding()
                SearchableSettings.highlightKey = restoreSettingKey
                navigator.push(SettingsScreen(SettingsScreen.Destination.DataAndStorage))
            },
        )
    }
}

private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
