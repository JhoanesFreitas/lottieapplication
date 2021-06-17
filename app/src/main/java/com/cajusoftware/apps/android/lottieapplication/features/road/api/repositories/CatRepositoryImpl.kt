package com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories

import com.cajusoftware.apps.android.lottieapplication.commons.dispatchers.CoroutineDispatchers
import com.cajusoftware.apps.android.lottieapplication.data.api.services.ApiService
import kotlinx.coroutines.withContext

class CatRepositoryImpl(
    private val apiService: ApiService,
    private val dispatchers: CoroutineDispatchers
) : CatRepository {

    override suspend fun getData() =
        withContext(dispatchers.io()) {
            apiService.getData()
        }
}