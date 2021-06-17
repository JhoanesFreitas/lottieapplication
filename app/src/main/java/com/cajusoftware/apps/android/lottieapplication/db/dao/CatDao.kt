package com.cajusoftware.apps.android.lottieapplication.db.dao

import androidx.room.*
import com.cajusoftware.apps.android.lottieapplication.db.constants.Queries.QUERY_DELETE_ALL
import com.cajusoftware.apps.android.lottieapplication.db.constants.Queries.QUERY_GET_ALL
import com.cajusoftware.apps.android.lottieapplication.db.constants.Queries.QUERY_GET_TEXT
import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus
import com.cajusoftware.apps.android.lottieapplication.db.models.Status

@Dao
interface CatDao {

    @Transaction
    @Query(QUERY_GET_ALL)
    suspend fun getAll(): List<CatAndStatus>

    @Query(QUERY_GET_TEXT)
    suspend fun getText(): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatsAndStatus(data: Cat, status: Status)

    @Query(QUERY_DELETE_ALL + "cat")
    suspend fun deleteAll()

}