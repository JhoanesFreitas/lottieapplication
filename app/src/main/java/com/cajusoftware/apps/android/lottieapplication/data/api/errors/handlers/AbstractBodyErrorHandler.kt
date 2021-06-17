package com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers

import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorData
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorHandler

internal abstract class AbstractBodyErrorHandler<T : Any> : ApiErrorHandler {
    private var error: T? = null

    override fun canHandle(errorData: ApiErrorData): Boolean {
        error = createError(errorData.errorBody)
        return error != null
    }

    override fun handle(errorData: ApiErrorData): Throwable {
        val currentError = requireNotNull(error)
        val throwable = createThrowable(currentError)
        error = null
        return throwable
    }

    abstract fun createError(errorBody: String): T?

    abstract fun createThrowable(error: T): Throwable
}