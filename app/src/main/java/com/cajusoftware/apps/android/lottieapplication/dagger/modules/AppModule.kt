package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import android.app.Application
import android.content.Context
import com.cajusoftware.apps.android.lottieapplication.commons.wrapper.JsonObjectWrapper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @Provides
    @Reusable
    internal fun provideJsonObjectWrapper(): JsonObjectWrapper =
        JsonObjectWrapper()
}