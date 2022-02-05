package com.firefly.todo

import android.graphics.RectF
import kotlin.math.PI

class Dot(x: Double, y: Double, z: Double) {
    var x: Double? = null
    var y: Double? = null
    var z: Double? = null
    var xProject: Double? = null
    var yProject: Double? = null
    var sizeProjection: Double? = null

    init {
        this.x = x
        this.y = y
        this.z = z

        this.xProject = 0.0
        this.yProject = 0.0
        this.sizeProjection = 0.0
    }



    fun project(sinRotation: Double, cosineRotation: Double) {
        val s = this.z!! - globe_center_Z
        val rotX = (cosineRotation * this.x!!) + (sinRotation * s)
        val rotZ = (-sinRotation * this.x!!) + (cosineRotation * s)+ globe_center_Z
        val d = field_of_view - rotZ
        this.sizeProjection = field_of_view / d
        this.xProject = (rotX * this.sizeProjection!!) + projection_centerX
        this.yProject = (this.y!! * this.sizeProjection!!) + projection_centerY

    }


    fun draw(sinRotation: Double, cosineRotation: Double) {
        this.project(sinRotation,cosineRotation)
        val oval : RectF = RectF(((this.xProject?.minus(globeradius))!!.toFloat()), ((this.yProject?.minus(globeradius))!!.toFloat()), ((this.xProject?.plus(globeradius))!!.toFloat()), ((this.yProject?.plus(globeradius))!!.toFloat()))

    }



}
