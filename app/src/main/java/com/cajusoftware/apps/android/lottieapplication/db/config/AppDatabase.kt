package com.cajusoftware.apps.android.lottieapplication.db.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cajusoftware.apps.android.lottieapplication.db.dao.CatDao
import com.cajusoftware.apps.android.lottieapplication.db.dao.StatusDao
import com.cajusoftware.apps.android.lottieapplication.db.models.BaseModel
import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.Status

@Database(entities = [BaseModel::class, Cat::class, Status::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
    abstract fun statusDao(): StatusDao
}