package com.cajusoftware.apps.android.lottieapplication.commons.models.responses

data class ErrorData(
    var message: String? = null,
    var messages: List<String>? = null,
    var exception: Throwable? = null
)
