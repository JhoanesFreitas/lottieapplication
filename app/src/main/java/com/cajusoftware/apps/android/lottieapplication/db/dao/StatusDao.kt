package com.cajusoftware.apps.android.lottieapplication.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cajusoftware.apps.android.lottieapplication.db.constants.Queries.QUERY_DELETE_ALL
import com.cajusoftware.apps.android.lottieapplication.db.models.Status

@Dao
interface StatusDao {

    @Insert
    suspend fun insertAll(vararg status: Status)

    @Query(QUERY_DELETE_ALL + "status")
    suspend fun deleteAll()
}