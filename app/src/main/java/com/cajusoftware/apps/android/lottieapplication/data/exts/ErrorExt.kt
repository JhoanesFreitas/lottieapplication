package com.cajusoftware.apps.android.lottieapplication.data.exts

import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorManager
import retrofit2.Response

fun <T> Response<T>?.handleError(): Throwable = ApiErrorManager.handleError(this)