package com.cajusoftware.apps.android.lottieapplication.commons.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.PopupWindow
import com.cajusoftware.apps.android.lottieapplication.R
import kotlinx.android.synthetic.main.layout_message_box.view.*
import javax.inject.Inject

class MessageBox @Inject constructor(
    context: Context, private val anchor: View
) :
    View.OnClickListener {

    private var tipWindow: PopupWindow = PopupWindow(context)
    private var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("InflateParams")
    private var contentView: View =
        layoutInflater.inflate(R.layout.layout_message_box, null)

    private var positionX: Int = 0
    private var positionY: Int = 0

    init {
        config()
    }

    private fun config() {
        tipWindow.height = WRAP_CONTENT
        tipWindow.width = WRAP_CONTENT

        tipWindow.isOutsideTouchable = true
        tipWindow.isTouchable = true
        tipWindow.isFocusable = true
        @Suppress("DEPRECATION")
        tipWindow.setBackgroundDrawable(BitmapDrawable())

        tipWindow.contentView = contentView

        val screenPos = IntArray(2)
        anchor.getLocationOnScreen(screenPos)

        val anchorRect = Rect(
            screenPos[0], screenPos[1], screenPos[0]
                    + anchor.width, screenPos[0] + anchor.height
        )

        contentView.measure(
            WRAP_CONTENT,
            WRAP_CONTENT
        )

        val contentViewHeight = contentView.measuredHeight
        val contentViewWidth = contentView.measuredWidth

        positionX = anchorRect.centerX() - contentViewWidth / 2
        positionY = anchorRect.bottom - (anchorRect.height() / 2)

        contentView.button_ok.setOnClickListener(this)
    }

    fun setText(msg: String) {
        contentView.message.text = msg
    }

    fun showTooltip() {
        tipWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, positionX, positionY)
    }

    override fun onClick(p0: View?) {
        dismissTooltip()
    }

    private fun dismissTooltip() {
        if (tipWindow.isShowing) tipWindow.dismiss()
    }
}