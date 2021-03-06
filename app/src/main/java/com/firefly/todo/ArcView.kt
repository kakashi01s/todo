package com.firefly.todo

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class ArcView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val ovalSpace = RectF()
    private var currentPercentage = 0
    private val parentArcPaint = Paint().apply {
        style = Paint.Style.STROKE
        isAntiAlias = true
        color = Color.GRAY
        strokeWidth = 40f
    }
    private val fillArcPaint = Paint().apply {
        style = Paint.Style.STROKE
        isAntiAlias = true
        color = Color.BLUE
        strokeWidth = 40f
        // 1
        strokeCap = Paint.Cap.ROUND
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
            setSpace()
        canvas?.let {
            drawBackgroundArc(it)
            // 3
            drawInnerArc(it)

        }
    }
    private fun drawBackgroundArc(it: Canvas) {
        it.drawArc(ovalSpace, 0f, 360f, false, parentArcPaint)
    }

    private fun drawInnerArc(canvas: Canvas) {
        val percentageToFill = getCurrentPercentageToFill()
        canvas.drawArc(ovalSpace, 20f, percentageToFill, false, fillArcPaint)
    }
    private fun getCurrentPercentageToFill() =
        (ARC_FULL_ROTATION_DEGREE * (currentPercentage / PERCENTAGE_DIVIDER)).toFloat()


    private fun setSpace() {
        val horizontalCenter = (width.div(2)).toFloat()
        val verticalCenter = (height.div(2)).toFloat()
        val ovalSize = 200
        ovalSpace.set(
            horizontalCenter - ovalSize,
            verticalCenter - ovalSize,
            horizontalCenter + ovalSize,
            verticalCenter + ovalSize
        )
    }
    fun animateProgress() {
        // 1
        val valuesHolder = PropertyValuesHolder.ofFloat(
            PERCENTAGE_VALUE_HOLDER,
            0f,
            100f
        )

        // 2
        val animator = ValueAnimator().apply {
            setValues(valuesHolder)
            duration = 10000
            interpolator = AccelerateDecelerateInterpolator()

            // 3
            addUpdateListener {

                // 4
                val percentage = it.getAnimatedValue(PERCENTAGE_VALUE_HOLDER) as Float

                // 5
                currentPercentage = percentage.toInt()

                // 6
                invalidate()
            }
        }
        // 7
        animator.start()
    }
    companion object {
        const val ARC_FULL_ROTATION_DEGREE = 360
        const val PERCENTAGE_DIVIDER = 100.0
        const val PERCENTAGE_VALUE_HOLDER = "percentage"
    }
}