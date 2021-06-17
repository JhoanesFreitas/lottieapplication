package com.cajusoftware.apps.android.lottieapplication.commons.exceptions

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.RegisterError

class NormalizeException(var erros: List<RegisterError>? = null) : Throwable(
    erros?.joinToString(separator = ", ") {
        it.message
    }
)