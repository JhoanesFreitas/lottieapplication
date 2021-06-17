package com.cajusoftware.apps.android.lottieapplication.features.road.db.repositories

import com.cajusoftware.apps.android.lottieapplication.commons.dispatchers.CoroutineDispatchers
import com.cajusoftware.apps.android.lottieapplication.db.config.AppDatabase
import com.cajusoftware.apps.android.lottieapplication.db.models.Cat
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus
import com.cajusoftware.apps.android.lottieapplication.db.models.Status
import kotlinx.coroutines.withContext

class DatabaseRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val dispatchers: CoroutineDispatchers
) : DatabaseRepository {

    override suspend fun insertCatAndStatus(cat: Cat, status: Status) =
        withContext(dispatchers.io()) {
            appDatabase.catDao().insertCatsAndStatus(cat, status)
        }

    override suspend fun getData(): List<CatAndStatus?> =
        withContext(dispatchers.io()) {
            appDatabase.catDao().getAll()
        }

    override suspend fun deleteAll() =
        withContext(dispatchers.io()) {
            appDatabase.clearAllTables()
        }
}