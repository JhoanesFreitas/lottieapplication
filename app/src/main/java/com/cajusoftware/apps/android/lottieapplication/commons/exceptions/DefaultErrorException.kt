package com.cajusoftware.apps.android.lottieapplication.commons.exceptions

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultErrorResponse

class DefaultErrorException(
    val errorResponse: DefaultErrorResponse
) : Exception() {

    private fun createLogMsg(): String =
        "Error code: ${errorResponse.error.code}, " +
                "Error message: ${errorResponse.error.message}, " +
                (errorResponse.error.details
                    ?.joinToString(prefix = " Details: ", separator = ", ") {
                        "Error code: ${errorResponse.error.code} + Error message: ${errorResponse.error.message}"
                    } ?: "") +
                (errorResponse.error.innerError
                    ?.toList()?.joinToString(prefix = " Inner Error: ", separator = ", ") {
                        "${it.first} - ${it.second}"
                    } ?: "") +
                "Request id: ${errorResponse.requestId}"

    override val message: String?
        get() = createLogMsg()
}