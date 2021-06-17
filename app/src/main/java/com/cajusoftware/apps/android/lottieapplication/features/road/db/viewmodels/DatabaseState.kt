package com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels

import androidx.lifecycle.LiveData
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus

data class DatabaseState(
    val isLoading: LiveData<Boolean>,
    val result: LiveData<List<CatAndStatus?>>,
    val goToApi: LiveData<Unit>
)