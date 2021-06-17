package com.cajusoftware.apps.android.lottieapplication.features.road.db.repositories

import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus
import com.cajusoftware.apps.android.lottieapplication.db.models.Status

interface DatabaseRepository {

    suspend fun insertCatAndStatus(cat: Cat, status: Status)
    suspend fun getData(): List<CatAndStatus?>
    suspend fun deleteAll()
}