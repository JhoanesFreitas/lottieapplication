package com.cajusoftware.apps.android.lottieapplication.commons.models.responses

import com.cajusoftware.apps.android.lottieapplication.data.exts.removeBrackets
import com.google.gson.annotations.SerializedName

data class ListErrorsResponse(
    @SerializedName("errors")
    val messages: List<String>
) {
    override fun toString(): String {
        return super.toString().removeBrackets
    }
}