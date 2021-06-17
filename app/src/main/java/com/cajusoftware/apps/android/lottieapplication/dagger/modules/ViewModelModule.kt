package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepository
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModelImpl
import com.cajusoftware.apps.android.lottieapplication.features.road.db.repositories.DatabaseRepository
import com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels.DatabaseViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels.DatabaseViewModelImpl
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

    @Provides
    @Reusable
    fun provideDatabaseViewModel(
        databaseRepository: DatabaseRepository
    ): DatabaseViewModel =
        DatabaseViewModelImpl(databaseRepository)
}