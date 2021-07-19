package com.cajusoftware.apps.android.lottieapplication.robot.splash

import androidx.annotation.IdRes
import androidx.test.rule.ActivityTestRule
import com.cajusoftware.apps.android.lottieapplication.data.api.urls.URLs
import com.cajusoftware.apps.android.lottieapplication.robot.BaseTestRobot
import com.cajusoftware.apps.android.lottieapplication.ui.SplashActivity
import com.cajusoftware.apps.android.lottieapplication.utils.JSONResponse
import com.cajusoftware.apps.android.lottietest.robots.ArrangeRobot
import com.cajusoftware.apps.android.lottietest.robots.AssertRobot
import com.cajusoftware.apps.android.lottietest.rules.ServerTestRule

internal class SplashArrangeRobot(
    serverTestRule: ServerTestRule,
    private val activityTestRule: ActivityTestRule<SplashActivity>? = null
) : BaseTestRobot() {

    private val arrangeRobot: ArrangeRobot = ArrangeRobot(serverTestRule)

    fun openScreen() {
        val intent = SplashActivity.startIntent(arrangeRobot.context)
        activityTestRule?.launchActivity(intent)
    }

    fun mockApiUnavailableError() {
        arrangeRobot.mockResponse(URLs.FACTS_ERROR, 400, JSONResponse.API_UNAVAILABLE.jsonPath)
    }

    fun mockApiReturnSuccessful() {
        arrangeRobot.mockResponse(URLs.FACTS, 200, JSONResponse.API_SUCCESSFUL.jsonPath)
    }
}

internal class SplashActionRobot {

}

internal class SplashAssertRobot(
    private val assertRobot: AssertRobot = AssertRobot()
) {

    fun checkIfAppNameIsVisible(text: String) =
        assertRobot.textIsVisible(text)

    fun checkIfViewIsVisible(@IdRes id: Int) =
        assertRobot.viewIsVisible(id)
}

internal fun arrange(
    serverTestRule: ServerTestRule,
    activityTestRule: ActivityTestRule<SplashActivity>,
    block: SplashArrangeRobot.() -> Unit
) {
    SplashArrangeRobot(
        serverTestRule,
        activityTestRule
    ).block()
}

internal fun assert(
    assertObject: SplashAssertRobot = SplashAssertRobot(),
    block: SplashAssertRobot.() -> Unit
) {
    assertObject.block()
}