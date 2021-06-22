package com.cajusoftware.apps.android.lottieapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.data.exts.observe
import com.cajusoftware.apps.android.lottieapplication.db.models.BaseModel
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.db.viewmodels.DatabaseViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.Serializable
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

    fun onTryAgain(v: View) {
        hideError()
        catViewModel.getData()
    }

    private fun showError() {
        error_layout.visibility = View.VISIBLE

        fullscreen_content.visibility = View.GONE
        progress_circular.visibility = View.GONE
    }

    private fun hideError() {
        fullscreen_content.visibility = View.VISIBLE
        progress_circular.visibility = View.VISIBLE

        error_layout.visibility = View.GONE
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
            val data = mutableListOf<Serializable>()

            it.forEach { catInformation ->
                catInformation?.let { cat ->
                    databaseViewModel.insertData(cat.toCat(), cat.toState())
                    data.add(CatAndStatus(cat.toCat(), cat.toState()))
                }
            }

            startActivity(
                MainActivity.getInstance(
                    this@SplashActivity, data.toTypedArray()
                )
            )
        }

        observe(viewState.isError) {
            showError()
        }
    }
}