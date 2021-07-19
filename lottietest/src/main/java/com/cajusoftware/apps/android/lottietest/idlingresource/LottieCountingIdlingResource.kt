package com.cajusoftware.apps.android.lottietest.idlingresource

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicInteger

class LottieCountingIdlingResource(
    private val resourceName: String
) : IdlingResource {

    private val counter = AtomicInteger(0)

    @Volatile
    var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String =
        resourceName

    override fun isIdleNow(): Boolean =
        counter.get() == 0

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.resourceCallback = callback
    }

    fun increment() =
        counter.getAndIncrement()

    fun decrement() {
        val counterAux = counter.decrementAndGet()

        if (counterAux == 0) {
            resourceCallback?.onTransitionToIdle()
        }

        if (counterAux < 0)
            throw IllegalArgumentException("Counter has been corrupted!")
    }
}