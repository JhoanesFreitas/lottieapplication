package com.cajusoftware.apps.android.lottieapplication.data.api.errors

data class ApiErrorData(
    val requestUrl: String,
    val responseCode: Int,
    val errorBody: String
)