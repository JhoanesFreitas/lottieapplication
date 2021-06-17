package com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels

import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.Status

interface DatabaseViewModel {

    val viewState: DatabaseState

    fun insertData(cat: Cat, status: Status)
    fun getData()
    fun deleteAll()
}