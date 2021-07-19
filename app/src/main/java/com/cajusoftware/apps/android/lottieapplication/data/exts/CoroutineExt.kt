package com.cajusoftware.apps.android.lottieapplication.data.exts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultError
import com.cajusoftware.apps.android.lottietest.idlingresource.EspressoIdlingResource
import kotlinx.coroutines.*

fun ViewModel.safeLaunch(
    error: (DefaultError) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) = viewModelScope.safeLaunch(error, block)

fun CoroutineScope.safeLaunch(
    error: (DefaultError) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) {
    launch {
        EspressoIdlingResource.increment()
        try {
            block.invoke(this)
        } catch (e: Exception) {
            val defaultError = e.convertToError()
            error.invoke(defaultError)
        } finally {
            EspressoIdlingResource.decrement()
        }
    }
}

@Suppress("DeferredResultUnused")
fun ViewModel.safeAsync(
    error: (DefaultError) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.async {
        EspressoIdlingResource.increment()
        try {
            supervisorScope {
                block.invoke(this)
            }
        } catch (e: Exception) {
            val defaultError = e.convertToError()
            error.invoke(defaultError)
        } finally {
            EspressoIdlingResource.decrement()
        }
    }
}

suspend fun <T> Deferred<T>.awaitOrNull(): T? {
    return try {
        this.await()
    } catch (e: Exception) {
        null
    }
}