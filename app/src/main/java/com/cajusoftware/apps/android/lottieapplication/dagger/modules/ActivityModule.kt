package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import com.cajusoftware.apps.android.lottieapplication.ui.BaseActivity
import com.cajusoftware.apps.android.lottieapplication.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}