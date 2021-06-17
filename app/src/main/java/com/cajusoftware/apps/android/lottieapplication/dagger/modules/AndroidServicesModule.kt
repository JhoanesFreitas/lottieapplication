package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import android.app.Application
import com.cajusoftware.apps.android.lottieapplication.commons.services.NetworkService
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class AndroidServicesModule {

    @Provides
    @Reusable
    fun providesNetworkService(
        context: Application
    ): NetworkService {
        return NetworkService(context)
    }
}