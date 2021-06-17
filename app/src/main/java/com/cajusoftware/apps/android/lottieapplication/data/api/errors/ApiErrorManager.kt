package com.cajusoftware.apps.android.lottieapplication.data.api.errors

import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers.ApiDefaultErrorHandler
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers.ApiListErrorHandler
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers.InternalServerErrorHandler
import com.cajusoftware.apps.android.lottieapplication.data.api.errors.handlers.NotFoundErrorHandler
import retrofit2.Response

object ApiErrorManager {

    private val errorHandlers: List<ApiErrorHandler> = arrayListOf(
        InternalServerErrorHandler(),
        ApiDefaultErrorHandler(),
        ApiListErrorHandler(),
        NotFoundErrorHandler()
    )

    private val defaultError: Throwable = Throwable(Errors.SERVER_ERROR.message)

    fun <T> handleError(response: Response<T>?): Throwable {
        if (response == null) return defaultError

        val requestUrl = getRequestedUrl(response)
        val errorData = ApiErrorData(
            requestUrl = requestUrl,
            responseCode = response.code(),
            errorBody = response.errorBody()?.string().orEmpty()
        )
        return handleError(errorData)
    }

    private fun <T> getRequestedUrl(response: Response<T>): String {
        return response
            .raw()
            .request
            .url
            .encodedPath
    }

    private fun handleError(errorData: ApiErrorData): Throwable {
        val errorHandler = errorHandlers
            .firstOrNull { it.canHandle(errorData) }

        return errorHandler?.handle(errorData) ?: defaultError
    }

    fun handleError(errorBody: String?): Throwable {
        val errorData = ApiErrorData(
            requestUrl = "",
            responseCode = -1,
            errorBody = errorBody.orEmpty()
        )
        return handleError(errorData)
    }
}