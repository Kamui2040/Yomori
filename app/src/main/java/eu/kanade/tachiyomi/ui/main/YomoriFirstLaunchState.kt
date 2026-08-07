package eu.kanade.tachiyomi.ui.main

internal fun shouldShowYomoriFirstLaunchFlow(
    yomoriWelcomeComplete: Boolean,
    onboardingComplete: Boolean,
): Boolean {
    return !yomoriWelcomeComplete || !onboardingComplete
}
