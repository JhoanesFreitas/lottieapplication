package com.cajusoftware.apps.android.lottieapplication.data.exts

import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors.CONNECTION_ERROR
import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors.SERVER_ERROR
import com.cajusoftware.apps.android.lottieapplication.commons.exceptions.DefaultErrorException
import com.cajusoftware.apps.android.lottieapplication.commons.exceptions.NormalizeException
import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.handleThrowable(): Throwable {

    val cause = this.cause

    return when {
        this is IOException -> {
            Throwable(CONNECTION_ERROR.message)
        }
        this is HttpException -> {
            response().handleError()
        }

        cause is NormalizeException -> {
            val response = cause.erros

            response?.let {
                Throwable(it[0].message)
            }

            Throwable(SERVER_ERROR.message)
        }
        else -> this
    }
}

fun Throwable.toDefaultError() = if (this is DefaultErrorException) {
    DefaultError(
        errorResponse.error.code,
        errorResponse.error.message,
        errorResponse.error.details,
        errorResponse.error.innerError
    )
} else {
    DefaultError("Unknown", this.message.orEmpty(), null, null)
}