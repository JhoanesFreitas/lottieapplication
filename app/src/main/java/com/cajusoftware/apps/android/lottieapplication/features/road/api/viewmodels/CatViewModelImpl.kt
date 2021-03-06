package com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultError
import com.cajusoftware.apps.android.lottieapplication.data.exts.emit
import com.cajusoftware.apps.android.lottieapplication.data.exts.safeLaunch
import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepository

class CatViewModelImpl(
    private val catRepository: CatRepository
) : CatViewModel, ViewModel() {

    override val viewState: CatInformationState = CatInformationState(
        isLoading = MutableLiveData(),
        result = MutableLiveData(),
        isError = MutableLiveData()
    )

    override fun getData() = safeLaunch(::onError) {
        viewState.isLoading.emit(true)

        val result = catRepository.getData()

        viewState.isLoading.emit(false)
        viewState.result.emit(result)
    }

    private fun onError(error: DefaultError) = with(viewState) {
        isLoading.emit(false)
        isError.emit(Unit)
    }

}