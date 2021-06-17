package com.cajusoftware.apps.android.lottieapplication.commons.models.responses

import com.google.gson.annotations.SerializedName

data class CatsInformation(
    @SerializedName("_id") val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("deleted") val deleted: Boolean,
    @SerializedName("user") val user: String,
    @SerializedName("text") val text: String,
    @SerializedName("__v") val v: Int,
    @SerializedName("source") val source: String,
    @SerializedName("updatedAt") val updateAt: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("used") val used: Boolean,
    @SerializedName("status") val status: Status
)