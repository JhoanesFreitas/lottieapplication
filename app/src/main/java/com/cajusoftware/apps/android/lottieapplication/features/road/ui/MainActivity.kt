package com.cajusoftware.apps.android.lottieapplication.features.road.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cajusoftware.apps.android.lottieapplication.R
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    companion object {
        private const val DATA = "data"
        fun getInstance(context: Context, data: Array<Serializable?>) =
            Intent(context, MainActivity::class.java)
                .putExtra(DATA, data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cats = intent.getSerializableExtra(DATA)
    }
}