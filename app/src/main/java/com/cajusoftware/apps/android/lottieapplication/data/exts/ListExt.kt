package com.cajusoftware.apps.android.lottieapplication.data.exts

fun List<String>.convertListToString(): String? =
    if (this.isNotEmpty()) {
        val errorMessage = StringBuilder()
        this.forEach { message ->
            if (indexOf(message) == lastIndex)
                errorMessage.append(message)
            else
                errorMessage.append(message + "\n")
        }

        errorMessage.toString()
    } else null

fun List<String>.join(): String = this.joinToString("\n")