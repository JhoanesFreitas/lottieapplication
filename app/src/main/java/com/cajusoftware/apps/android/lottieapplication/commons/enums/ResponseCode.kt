package com.cajusoftware.apps.android.lottieapplication.commons.enums

enum class ResponseCode(val value: Int, val range: IntRange = 0..0) {
    OK(0, 200..299),
    CLIENT_ERROR(0, 400..499),
    NOT_FOUND(404),
    INTERNAL_ERROR(0, 500..599)
}