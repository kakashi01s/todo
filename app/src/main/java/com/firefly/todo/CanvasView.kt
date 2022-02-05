package com.firefly.todo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

const val dots_amount = 1000
const val dot_radius = 4
const val globeradius = 20.00
const val globe_center_Z = -globeradius
const val projection_centerX = 50
const val projection_centerY = 50
const val field_of_view = 8
val dots : ArrayList<Any> = ArrayList()

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    val paint: Paint = Paint()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.WHITE


            fun render(a : Int) {




        }

        }




    fun createDots(a : Int) {
        for(i in 0..dots_amount)
        {
            val theta = Math.random() * 2 * PI
            val phi = acos((Math.random() * 2) - 1)
            val x = globeradius * sin(phi) * cos(theta)
            val y = globeradius * sin(phi) * sin(theta)
            val z = (globeradius * cos(phi) ) + globe_center_Z
            dots.add(Dot(x,y,z))

            val rotation = a * 0.0004
            val sinRotation = sin(rotation)
            val cosineRotation = cos(rotation)
            for (i in 0..dots.size)
            {
                val s = dots[i]


            }

        }




        }



    }



