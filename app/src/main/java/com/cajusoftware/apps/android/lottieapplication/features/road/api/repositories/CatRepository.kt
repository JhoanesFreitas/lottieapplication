package com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.CatsInformation

interface CatRepository {
    suspend fun getData(): Array<CatsInformation?>
}