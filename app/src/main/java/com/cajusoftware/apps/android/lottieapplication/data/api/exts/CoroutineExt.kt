package com.cajusoftware.apps.android.lottieapplication.data.api.exts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultError
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
        try {
            block.invoke(this)
        } catch (e: Exception) {
            val defaultError = e.convertToError()
            error.invoke(defaultError)
        }
    }
}

fun ViewModel.safeAsync(
    error: (DefaultError) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.async {
        try {
            supervisorScope {
                block.invoke(this)
            }
        } catch (e: Exception) {
            val defaultError = e.convertToError()
            error.invoke(defaultError)
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