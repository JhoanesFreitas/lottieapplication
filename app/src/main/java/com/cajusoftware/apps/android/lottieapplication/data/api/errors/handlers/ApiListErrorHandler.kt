package com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers

import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.ListErrorsResponse
import com.cajusoftware.apps.android.lottieapplication.data.exts.convertListToString
import com.cajusoftware.apps.android.lottieapplication.data.exts.toDataClass

internal class ApiListErrorHandler : AbstractBodyErrorHandler<ListErrorsResponse>() {

    override fun createError(errorBody: String): ListErrorsResponse? {
        val listErrorsResponse = errorBody.toDataClass(ListErrorsResponse::class.java)

        return if (listErrorsResponse?.messages == null) {
            null
        } else {
            listErrorsResponse
        }
    }

    override fun createThrowable(error: ListErrorsResponse): Throwable {
        val message = error.messages.convertListToString() ?: Errors.BAD_REQUEST.message
        return Throwable(message)
    }
}