package com.cajusoftware.apps.android.lottieapplication.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity
data class Status(
    val catOwnerId: String,
    @ColumnInfo(name = "verified") val verified: Boolean,
    @ColumnInfo(name = "sentCount") val sentCount: Int
) : BaseModel(UUID.randomUUID().toString())
