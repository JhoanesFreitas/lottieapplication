package com.cajusoftware.apps.android.lottieapplication.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
open class BaseModel(
    @PrimaryKey var id: String,
    var createdTime: Long = 0,
) : Serializable {

    init {
        val dt = Date()
        val c: Calendar = Calendar.getInstance()
        c.time = dt
        c.add(Calendar.DATE, 1)
        createdTime = c.timeInMillis

    }
}