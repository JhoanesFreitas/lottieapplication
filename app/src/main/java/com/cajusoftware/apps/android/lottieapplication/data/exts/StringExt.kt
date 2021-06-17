package com.cajusoftware.apps.android.lottieapplication.data.exts

val String.removeBrackets
    get() = this.replace("(^\\[|\\]$)", "")