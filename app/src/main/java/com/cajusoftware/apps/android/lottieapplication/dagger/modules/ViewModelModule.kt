package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepository
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModelImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ViewModelModule {

    @Provides
    @Reusable
    fun provideCatViewModel(
        catRepository: CatRepository
    ): CatViewModel =
        CatViewModelImpl(catRepository)
}