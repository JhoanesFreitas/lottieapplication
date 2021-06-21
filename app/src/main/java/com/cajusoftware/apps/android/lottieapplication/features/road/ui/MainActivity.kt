package com.cajusoftware.apps.android.lottieapplication.features.road.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.data.exts.gone
import com.cajusoftware.apps.android.lottieapplication.data.exts.visible
import kotlinx.android.synthetic.main.layout_elephant.view.*
import kotlinx.android.synthetic.main.road_layout.*
import kotlinx.android.synthetic.main.text_view_number.view.*
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

        setNumbers()
        showElephantInFirstStep()
    }

    private fun setNumbers() {
        bottom_step_1.text_number.text = getText(R.string.step_one)
        bottom_step_2.text_number.text = getText(R.string.step_two)
        bottom_step_3.text_number.text = getText(R.string.step_three)
        bottom_step_4.text_number.text = getText(R.string.step_four)
        bottom_step_5.text_number.text = getText(R.string.step_five)
    }

    fun onClick(v: View) {
        hideAllElephants()
        v.elephant.visible()
        v.elephant.playAnimation()
    }

    private fun hideAllElephants() {
        bottom_step_1.elephant.gone()
        bottom_step_2.elephant.gone()
        bottom_step_3.elephant.gone()
        bottom_step_4.elephant.gone()
        bottom_step_5.elephant.gone()
    }

    private fun showElephantInFirstStep() {
        bottom_step_1.elephant.visible()
    }
}