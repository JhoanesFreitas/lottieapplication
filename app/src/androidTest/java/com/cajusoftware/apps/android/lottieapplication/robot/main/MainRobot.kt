package com.cajusoftware.apps.android.lottieapplication.robot.main

import androidx.annotation.IdRes
import androidx.test.rule.ActivityTestRule
import com.cajusoftware.apps.android.lottieapplication.data.api.urls.URLs
import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import com.cajusoftware.apps.android.lottieapplication.robot.BaseTestRobot
import com.cajusoftware.apps.android.lottieapplication.ui.SplashActivity
import com.cajusoftware.apps.android.lottieapplication.utils.JSONResponse
import com.cajusoftware.apps.android.lottietest.robots.ArrangeRobot
import com.cajusoftware.apps.android.lottietest.robots.AssertRobot
import com.cajusoftware.apps.android.lottietest.rules.ServerTestRule

internal class MainArrangeRobot(
    serverTestRule: ServerTestRule,
    private val activityTestRule: ActivityTestRule<MainActivity>? = null
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

internal class MainAssertRobot(
    private val assertRobot: AssertRobot = AssertRobot()
) {

    fun checkIfAppNameIsVisible(text: String) =
        assertRobot.textIsVisible(text)

    fun checkIfViewIsVisible(@IdRes id: Int) =
        assertRobot.viewIsVisible(id)
}

internal fun arrange(
    serverTestRule: ServerTestRule,
    activityTestRule: ActivityTestRule<MainActivity>,
    block: MainArrangeRobot.() -> Unit
) {
    MainArrangeRobot(
        serverTestRule,
        activityTestRule
    ).block()
}

internal fun assert(
    assertObject: MainAssertRobot = MainAssertRobot(),
    block: MainAssertRobot.() -> Unit
) {
    assertObject.block()
}