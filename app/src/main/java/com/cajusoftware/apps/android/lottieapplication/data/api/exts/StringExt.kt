package com.cajusoftware.apps.android.lottieapplication.data.api.exts

val String.removeBrackets
    get() = this.replace("(^\\[|\\]$)", "")