package com.cajusoftware.apps.android.lottieapplication.commons.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineDispatchersImpl : CoroutineDispatchers {
    override fun main(): CoroutineDispatcher = Dispatchers.Main
    override fun io(): CoroutineDispatcher = Dispatchers.IO
    override fun default(): CoroutineDispatcher = Dispatchers.Default
}