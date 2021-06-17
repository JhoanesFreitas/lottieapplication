package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import android.content.Context
import androidx.room.Room
import com.cajusoftware.apps.android.lottieapplication.BuildConfig
import com.cajusoftware.apps.android.lottieapplication.db.config.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        context: Context
    ) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, BuildConfig.CATS_DATABASE_NAME
        ).build()
}