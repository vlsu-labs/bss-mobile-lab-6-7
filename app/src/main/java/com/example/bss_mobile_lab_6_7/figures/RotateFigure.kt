package com.example.bss_mobile_lab_6_7.figures

import kotlin.math.cos
import kotlin.math.sin

abstract class RotateFigure<T>(
    protected val center: Pair<Float, Float>,
    protected val width: Float,
    protected val rotateAngle: Float
) : IFigure {

    protected fun rotateVector(vector: Pair<Float, Float>): Pair<Float, Float> {
//        x1=x*cos(angle)-y*sin(angle);
//        y1=y*cos(angle)+x*sin(angle);
        var cs = cos(Math.toRadians(rotateAngle.toDouble())).toFloat()
        var sn = sin(Math.toRadians(rotateAngle.toDouble())).toFloat()
        return Pair(
            vector.first* cs - vector.second* sn,
            vector.second* cs + vector.first* sn
        )
    }

    protected abstract suspend fun rotateSequence(): Sequence<T>
}