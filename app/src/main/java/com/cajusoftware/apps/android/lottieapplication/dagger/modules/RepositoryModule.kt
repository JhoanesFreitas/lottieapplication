package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.commons.dispatchers.CoroutineDispatchers
import com.cajusoftware.apps.android.lottieapplication.data.api.services.ApiService
import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepository
import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

    @Provides
    @Reusable
    fun provideCatRepository(
        apiService: ApiService,
        dispatchers: CoroutineDispatchers
    ): CatRepository =
        CatRepositoryImpl(apiService, dispatchers)
}