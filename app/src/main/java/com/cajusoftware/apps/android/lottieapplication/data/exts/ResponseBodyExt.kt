package com.cajusoftware.apps.android.lottieapplication.data.exts

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.RegisterError
import com.google.gson.Gson

inline fun <reified T> String.toDataClass(ofClass: Class<T>): T? =
    try {
        Gson().fromJson(this, ofClass)
    } catch (e: Exception) {
        null
    }

fun String.toErrorListRegisterDataClass(): List<RegisterError>? =
    try {
        Gson()
            .fromJson(this, Array<RegisterError>::class.java)
            .toList()
    } catch (e: Exception) {
        null
    }