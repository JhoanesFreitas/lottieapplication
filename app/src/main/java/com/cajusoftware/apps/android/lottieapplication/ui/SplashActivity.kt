package com.cajusoftware.apps.android.lottieapplication.ui

import android.os.Bundle
import android.util.Log
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.data.exts.observe
import com.cajusoftware.apps.android.lottieapplication.db.models.BaseModel
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels.DatabaseViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var catViewModel: CatViewModel

    @Inject
    lateinit var databaseViewModel: DatabaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setApiObservers()
        setDatabaseObservers()
    }

    override fun onStart() {
        super.onStart()
        databaseViewModel.getData()
    }

    private fun setDatabaseObservers() = with(databaseViewModel) {

        observe(viewState.isLoading) {
            Log.d("Log", if (it) "\nLoading database...\n" else "\nStop loading database!\n")
        }

        observe(viewState.goToApi) {
            databaseViewModel.deleteAll()
            catViewModel.getData()
        }

        observe(viewState.result) {
            Log.d("Log", it.toString())
            startActivity(
                MainActivity.getInstance(
                    this@SplashActivity, it.toTypedArray()
                )
            )
        }
    }

    private fun setApiObservers() = with(catViewModel) {

        observe(viewState.isLoading) {
            Log.d(
                "Log",
                if (it) "\nLoading data from API...\n" else "\nStop loading data from API!\n"
            )
        }

        observe(viewState.result) {
            Log.d("Log", it.toString())
            val data = mutableListOf<BaseModel>()

            it.forEach { catInformation ->
                catInformation?.let { cat ->
                    databaseViewModel.insertData(cat.toCat(), cat.toState())
                }
            }

            startActivity(
                MainActivity.getInstance(
                    this@SplashActivity, data.toTypedArray()
                )
            )
        }
    }
}