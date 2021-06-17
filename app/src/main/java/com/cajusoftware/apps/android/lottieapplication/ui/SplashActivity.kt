package com.cajusoftware.apps.android.lottieapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.data.api.exts.observe
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.CatViewModel
import com.cajusoftware.apps.android.lottieapplication.features.road.ui.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var catViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setObservers()
    }

    override fun onStart() {
        super.onStart()
        catViewModel.getData()
    }

    private fun setObservers() = with(catViewModel) {

        observe(viewState.isLoading) {
            Log.d("Log", if (it) "\nLoading...\n" else "\nStop loading!\n")
        }

        observe(viewState.result) {
            Log.d("Log", it.toString())
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}