package com.cajusoftware.apps.android.lottieapplication.core

import com.cajusoftware.apps.android.lottieapplication.core.dagger.DaggerTestAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

internal class UITestApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestAppComponent.builder().create(this).build()
    }
}