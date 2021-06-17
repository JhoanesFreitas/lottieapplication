package com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers

import com.cajusoftware.apps.android.lottieapplication.commons.enums.ResponseCode
import com.cajusoftware.apps.android.lottieapplication.commons.exceptions.InternalServerErrorException
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorData
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.ApiErrorHandler

internal class InternalServerErrorHandler : ApiErrorHandler {
    override fun canHandle(errorData: ApiErrorData): Boolean {
        return errorData.responseCode in ResponseCode.INTERNAL_ERROR.range
    }

    override fun handle(errorData: ApiErrorData): Throwable {
        return InternalServerErrorException()
    }
}