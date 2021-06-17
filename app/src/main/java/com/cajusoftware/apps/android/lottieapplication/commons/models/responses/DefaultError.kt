package com.cajusoftware.apps.android.lottieapplication.commons.models.responses

open class DefaultError(
    val code: String,
    val message: String,
    val details: List<DefaultError>? = null,
    val innerError: Map<String, Any>? = null
)
