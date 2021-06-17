package com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers

import com.cajusoftware.apps.android.lottieapplication.commons.exceptions.DefaultErrorException
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultErrorResponse
import com.cajusoftware.apps.android.lottieapplication.data.api.exts.toDataClass

internal class ApiDefaultErrorHandler : AbstractBodyErrorHandler<DefaultErrorResponse>() {

    override fun createError(errorBody: String): DefaultErrorResponse? {
        val defaultErrorResponse = errorBody.toDataClass(DefaultErrorResponse::class.java)

        return if (defaultErrorResponse?.error == null && defaultErrorResponse?.requestId == null) {
            null
        } else {
            defaultErrorResponse
        }
    }

    override fun createThrowable(error: DefaultErrorResponse): Throwable {
        return DefaultErrorException(error)
    }
}