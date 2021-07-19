package com.cajusoftware.apps.android.lottietest.utils.extentions

import android.content.Context

fun Context.resolveJsonPath(path: String): String {
    val uri = assets.open(path)
    return String(uri.readBytes())
}