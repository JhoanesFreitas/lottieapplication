package com.cajusoftware.apps.android.lottieapplication.db.models

import androidx.room.Entity

@Entity
data class Cat(
    val catId: String,
    val type: String,
    val deleted: Boolean,
    val user: String,
    val text: String,
    val v: Int,
    val source: String,
    val updateAt: String,
    val createdAt: String,
    val used: Boolean,
) : BaseModel(catId)
