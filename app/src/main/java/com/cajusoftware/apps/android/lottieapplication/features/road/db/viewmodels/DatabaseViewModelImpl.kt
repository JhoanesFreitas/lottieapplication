package com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cajusoftware.apps.android.lottieapplication.data.exts.emit
import com.cajusoftware.apps.android.lottieapplication.data.exts.safeAsync
import com.cajusoftware.apps.android.lottieapplication.data.exts.safeLaunch
import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.Status
import com.cajusoftware.apps.android.lottieapplication.features.road.db.repositories.DatabaseRepository

class DatabaseViewModelImpl(
    private val databaseRepository: DatabaseRepository
) : DatabaseViewModel, ViewModel() {

    override val viewState: DatabaseState =
        DatabaseState(
            isLoading = MutableLiveData(),
            result = MutableLiveData(),
            goToApi = MutableLiveData(),
        )

    override fun insertData(cat: Cat, status: Status) = safeAsync {
        databaseRepository.insertCatAndStatus(cat, status)
    }

    override fun getData() = safeLaunch {
        viewState.isLoading.emit(true)
        val result = databaseRepository.getData()

        when {
            result.isEmpty() -> viewState.goToApi.emit(Unit)
            result[0]?.cat?.createdTime ?: 0 < System.currentTimeMillis() ->
                viewState.goToApi.emit(Unit)
            else -> {
                viewState.result.emit(result)
            }
        }

        viewState.isLoading.emit(false)
    }

    override fun deleteAll() = safeAsync {
        databaseRepository.deleteAll()
    }
}