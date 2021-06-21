package com.cajusoftware.apps.android.lottieapplication.features.road.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.cajusoftware.apps.android.lottieapplication.R
import com.cajusoftware.apps.android.lottieapplication.commons.components.MessageBox
import com.cajusoftware.apps.android.lottieapplication.data.exts.gone
import com.cajusoftware.apps.android.lottieapplication.data.exts.visible
import com.cajusoftware.apps.android.lottieapplication.db.models.CatAndStatus
import kotlinx.android.synthetic.main.layout_elephant.view.*
import kotlinx.android.synthetic.main.road_layout.*
import kotlinx.android.synthetic.main.text_view_number.view.*
import java.io.Serializable


class MainActivity : AppCompatActivity(), LifecycleOwner {

    companion object {
        private const val DATA = "data"
        fun getInstance(context: Context, data: Array<Serializable?>) =
            Intent(context, MainActivity::class.java)
                .putExtra(DATA, data)
    }

    private var cats: Array<Serializable> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cats = intent.getSerializableExtra(DATA) as Array<Serializable>

        setNumbers()
        showElephantInFirstStep()

    }

    fun onClick(v: View) {
        hideAllElephants()
        v.elephant.visible()
        v.elephant.playAnimation()
        balloon(v)
    }

    private fun balloon(view: View) {
        val msgBox = MessageBox(this, view)

        when (view.id) {
            R.id.bottom_step_1 -> msgBox.setText(getMsg(0))
            R.id.bottom_step_2 -> msgBox.setText(getMsg(1))
            R.id.bottom_step_3 -> msgBox.setText(getMsg(2))
            R.id.bottom_step_4 -> msgBox.setText(getMsg(3))
            R.id.bottom_step_5 -> msgBox.setText(getMsg(4))
        }

        msgBox.showTooltip()
    }

    private fun getMsg(id: Int) =
        (cats[id] as CatAndStatus).cat.text

    private fun setNumbers() {
        bottom_step_1.text_number.text = getText(R.string.step_one)
        bottom_step_2.text_number.text = getText(R.string.step_two)
        bottom_step_3.text_number.text = getText(R.string.step_three)
        bottom_step_4.text_number.text = getText(R.string.step_four)
        bottom_step_5.text_number.text = getText(R.string.step_five)
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