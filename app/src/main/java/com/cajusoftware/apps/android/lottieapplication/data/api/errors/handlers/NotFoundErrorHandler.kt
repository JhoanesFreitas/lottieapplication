package com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers

import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors
import com.cajusoftware.apps.android.lottieapplication.commons.enums.ResponseCode
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorData
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorHandler

internal class NotFoundErrorHandler : ApiErrorHandler {
    override fun canHandle(errorData: ApiErrorData): Boolean {
        return errorData.responseCode == ResponseCode.NOT_FOUND.value
    }

    override fun handle(errorData: ApiErrorData): Throwable {
        return Throwable(Errors.NOT_FOUND.message)
    }
}