package com.cajusoftware.apps.android.lottieapplication.features.road.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.db.models.BaseModel
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context, data: Array<Serializable?>) =
            Intent(context, MainActivity::class.java)
                .putExtra("data", data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}