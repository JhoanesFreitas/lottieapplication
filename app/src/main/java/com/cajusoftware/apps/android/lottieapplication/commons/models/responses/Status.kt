package com.cajusoftware.apps.android.lottieapplication.commons.models.responses

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("verified") val verified: Boolean,
    @SerializedName("sentCount") val sentCount: Int
)