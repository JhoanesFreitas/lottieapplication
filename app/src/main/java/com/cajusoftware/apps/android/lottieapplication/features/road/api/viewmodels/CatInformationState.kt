package com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels

import androidx.lifecycle.LiveData
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.CatsInformation

data class CatInformationState(
    val isLoading: LiveData<Boolean>,
    val result: LiveData<Array<CatsInformation>?>,
)