package com.cajusoftware.apps.android.lottietest.idlingresource

import androidx.test.espresso.IdlingResource

private const val RESOURCE = "global"

class EspressoIdlingResource {

    companion object {

        private val countingIdlingResource =
            LottieCountingIdlingResource(RESOURCE)

        fun increment() {
            countingIdlingResource.increment()
        }

        fun decrement() =
            countingIdlingResource.decrement()

        fun getIdlingResource(): IdlingResource =
            countingIdlingResource
    }
}