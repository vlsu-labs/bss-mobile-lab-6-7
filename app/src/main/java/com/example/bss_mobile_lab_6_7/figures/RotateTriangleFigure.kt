package com.example.bss_mobile_lab_6_7.figures

import android.R.attr.x
import android.R.attr.y
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path


open class RotateTriangleFigure(center: Pair<Float, Float>, width: Float, rotateAngle: Float) :
    RotateFigure<Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>>(center, width, rotateAngle) {
    override suspend fun rotateSequence() = sequence {
        var count = (360 / rotateAngle).toInt()

        if ((count * rotateAngle).toInt() != 360) {
            throw IllegalArgumentException("Can't rotate on full circle")
        }

        var vector = Pair(width, 0F)

        for (i in 0 until count - 1)
        {
            var rotateVector = rotateVector(vector)

            yield(Triple(
                Pair(center.first + vector.first, center.second + vector.second),
                Pair(center.first + rotateVector.first, center.second + rotateVector.second),
                center.copy()))

            vector = rotateVector
        }

        yield(Triple(
            Pair(center.first + vector.first, center.second + vector.second),
            Pair(center.first + width, center.second),
            center.copy()
        ))
    }

    override suspend fun draw(canvas: Canvas, paint: Paint) {
        var dbg = rotateSequence().toList()
        for (figure in rotateSequence().toList().iterator()) {
            val path = Path()
            path.moveTo(figure.first.first, figure.first.second)

            path.lineTo(figure.second.first, figure.second.second)

            path.lineTo(figure.third.first, figure.third.second)

            path.lineTo(figure.first.first, figure.first.second)

            path.close()

            canvas.drawPath(path, paint)
        }
    }
}