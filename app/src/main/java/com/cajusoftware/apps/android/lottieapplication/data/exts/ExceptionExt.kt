package com.cajusoftware.apps.android.lottieapplication.data.exts

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.DefaultError

fun Throwable.convertToError(): DefaultError = handleThrowable().toDefaultError()