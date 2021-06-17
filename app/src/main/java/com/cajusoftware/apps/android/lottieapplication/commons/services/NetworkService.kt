package com.cajusoftware.apps.android.lottieapplication.commons.services

import android.content.Context
import android.net.ConnectivityManager

class NetworkService(private val context: Context) {

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        return connectivityManager?.activeNetworkInfo?.isConnected ?: false
    }
}