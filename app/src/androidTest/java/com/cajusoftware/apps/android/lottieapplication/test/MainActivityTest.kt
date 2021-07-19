package com.cajusoftware.apps.android.lottieapplication.test

import androidx.test.espresso.intent.Intents
import androidx.test.rule.ActivityTestRule
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import com.cajusoftware.apps.android.lottieapplication.robot.main.arrange
import com.cajusoftware.apps.android.lottieapplication.robot.main.assert
import com.cajusoftware.apps.android.lottietest.rules.ServerTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainActivityTest {

    @get:Rule
    val activityMainRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val serverTestRule = ServerTestRule.create()

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun whenOpenScreenShouldShowTrees() {
        arrange(serverTestRule, activityMainRule) {
        }

        assert {
            checkIfViewIsVisible(R.id.bottom_tree_1)
        }
    }
}