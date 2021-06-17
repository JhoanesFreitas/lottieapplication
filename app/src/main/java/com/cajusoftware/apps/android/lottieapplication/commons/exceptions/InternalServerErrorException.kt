package com.cajusoftware.apps.android.lottieapplication.commons.exceptions

import com.cajusoftware.apps.android.lottieapplication.commons.enums.Errors

class InternalServerErrorException(message: String) : Exception(message) {
    constructor() : this(Errors.SERVER_ERROR.message)
}