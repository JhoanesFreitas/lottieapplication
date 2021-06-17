package com.cajusoftware.apps.android.lottieapplication.db.models

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

data class CatAndStatus(
    @Embedded val cat: Cat,
    @Relation(
        parentColumn = "catId",
        entityColumn = "catOwnerId"
    )
    val status: Status
) : Serializable