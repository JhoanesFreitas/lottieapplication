package com.cajusoftware.apps.android.lottieapplication.ui

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var app: Context

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}