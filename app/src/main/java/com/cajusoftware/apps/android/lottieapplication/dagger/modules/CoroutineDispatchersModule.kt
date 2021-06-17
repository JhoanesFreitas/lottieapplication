package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.commons.dispatchers.CoroutineDispatchers
import com.cajusoftware.apps.android.lottieapplication.commons.dispatchers.CoroutineDispatchersImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoroutineDispatchersModule {

    @Provides
    @Singleton
    fun provideDispatchers(): CoroutineDispatchers =
        CoroutineDispatchersImpl()
}