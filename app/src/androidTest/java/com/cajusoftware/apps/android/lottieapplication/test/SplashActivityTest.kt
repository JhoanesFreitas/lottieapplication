package com.cajusoftware.apps.android.lottieapplication.test

import androidx.annotation.IdRes
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.intent.Intents
import androidx.test.rule.ActivityTestRule
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels.DatabaseViewModel
import com.cajusoftware.apps.android.lottieapplication.robot.splash.arrange
import com.cajusoftware.apps.android.lottieapplication.robot.splash.assert
import com.cajusoftware.apps.android.lottieapplication.ui.SplashActivity
import com.cajusoftware.apps.android.lottietest.idlingresource.EspressoIdlingResource
import com.cajusoftware.apps.android.lottietest.rules.ServerTestRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

internal class SplashActivityTest {

    @get:Rule
    val activitySplashRule: ActivityTestRule<SplashActivity> = ActivityTestRule(SplashActivity::class.java)

    @get:Rule
    val serverTestRule = ServerTestRule.create()

//    var databaseViewModel: DatabaseViewModel = mockk()

    private val countingResource =
        EspressoIdlingResource.getIdlingResource()

    @Before
    fun setUp() {
//        databaseViewModel.deleteAll()
        IdlingRegistry.getInstance().register(countingResource)
        Intents.init()
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(countingResource)
        Intents.release()
    }

    private fun string(@IdRes id: Int): String {
        val targetContext = InstrumentationRegistry.getTargetContext()
        return targetContext.resources.getString(id)
    }

    @Test
    fun whenOpenAppShouldShowAppName() {
        arrange(serverTestRule, activitySplashRule) {
            mockApiReturnSuccessful()
        }

        assert {
            checkIfAppNameIsVisible(string(R.string.app_name))
        }
    }

    @Test
    fun whenOpenAppShouldShowElephantAnimation() {
        arrange(serverTestRule, activitySplashRule) {
            mockApiReturnSuccessful()
        }

        assert {
            checkIfViewIsVisible(R.id.elephant_animation)
        }
    }

    @Test
    fun whenOpenAppShouldShowProgressCircular() {
        arrange(serverTestRule, activitySplashRule) {
            mockApiReturnSuccessful()
        }

        assert {
            checkIfViewIsVisible(R.id.progress_circular)
        }
    }

    @Test
    fun whenRequestApiDataWithApiUnavailableShouldErrorMessage() {
        arrange(serverTestRule, activitySplashRule) {
            mockApiUnavailableError()
        }

        assert {
            checkIfViewIsVisible(R.id.error_img)
            checkIfViewIsVisible(R.id.error_title)
            checkIfViewIsVisible(R.id.try_again_button)
        }
    }
}