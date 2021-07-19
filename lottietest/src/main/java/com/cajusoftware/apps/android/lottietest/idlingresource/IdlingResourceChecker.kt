package com.cajusoftware.apps.android.lottietest.idlingresource

class IdlingResourceChecker {

    companion object {
        fun checkDecrement() {
            if (!EspressoIdlingResource.getIdlingResource().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }

        fun checkIncrement() {
            EspressoIdlingResource.increment()
        }

    }
}