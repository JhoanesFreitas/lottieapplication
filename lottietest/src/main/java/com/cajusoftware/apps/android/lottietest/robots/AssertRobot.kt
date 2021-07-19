package com.cajusoftware.apps.android.lottietest.robots

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE

class AssertRobot {

    fun textIsVisible(text: String, isDisplayed: Boolean = true) {
        onView(withText(text))
            .check(matches(resolveVisibilityMatcher(isDisplayed)))
    }

    fun viewIsVisible(@IdRes id: Int, isDisplayed: Boolean = true) {
        onView(withId(id))
            .check(matches(resolveVisibilityMatcher(isDisplayed)))
    }

    private fun resolveVisibilityMatcher(isDisplayed: Boolean) =
        if (isDisplayed) isDisplayed() else withEffectiveVisibility(VISIBLE)
}