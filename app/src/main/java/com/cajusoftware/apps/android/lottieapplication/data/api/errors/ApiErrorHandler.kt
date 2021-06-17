package com.cajusoftware.apps.android.lottieapplication.data.api.errors

interface ApiErrorHandler {
    fun canHandle(errorData: ApiErrorData): Boolean
    fun handle(errorData: ApiErrorData): Throwable
}