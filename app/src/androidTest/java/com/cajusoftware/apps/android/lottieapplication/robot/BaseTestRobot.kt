package com.cajusoftware.apps.android.lottieapplication.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry

internal open class BaseTestRobot {

    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    fun clickStep(resId: Int): ViewInteraction =
        onView(withId(resId)).perform(ViewActions.click())

    fun textView(resId: Int): ViewInteraction =
        onView(withId(resId))

    fun isDisplayedView(resId: Int): ViewInteraction =
        onView(withId(resId)).check(matches(isDisplayed()))

    fun matchText(viewInteraction: ViewInteraction, text: String):
            ViewInteraction =
        viewInteraction.check(matches(ViewMatchers.withText(text)))

}