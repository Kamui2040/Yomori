package eu.kanade.tachiyomi.ui.main

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class YomoriFirstLaunchStateTest {

    @Test
    fun `new installation shows first launch flow`() {
        shouldShowYomoriFirstLaunchFlow(
            yomoriWelcomeComplete = false,
            onboardingComplete = false,
        ) shouldBe true
    }

    @Test
    fun `existing user still receives Yomori acknowledgement once`() {
        shouldShowYomoriFirstLaunchFlow(
            yomoriWelcomeComplete = false,
            onboardingComplete = true,
        ) shouldBe true
    }

    @Test
    fun `acknowledged user still receives unfinished setup`() {
        shouldShowYomoriFirstLaunchFlow(
            yomoriWelcomeComplete = true,
            onboardingComplete = false,
        ) shouldBe true
    }

    @Test
    fun `completed acknowledgement and setup show no mandatory flow`() {
        shouldShowYomoriFirstLaunchFlow(
            yomoriWelcomeComplete = true,
            onboardingComplete = true,
        ) shouldBe false
    }
}
