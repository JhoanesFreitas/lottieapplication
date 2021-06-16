package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}