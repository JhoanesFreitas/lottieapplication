package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class URLsModule {

    @Provides
    @Singleton
    @Named("urlDomain")
    fun provideUrlDomain(): String =
        BuildConfig.CATS_API
}