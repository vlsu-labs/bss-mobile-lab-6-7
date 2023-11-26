package com.example.bss_mobile_lab_6_7.draw_utils

import android.view.SurfaceView
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.view.SurfaceHolder
import android.view.View

class DrawView(context: Context): View(context) {
    private val p: Paint = Paint()
    private val rectf: RectF = RectF(700F, 100F, 800F, 150F)

    private val points: FloatArray = floatArrayOf(100F, 50F, 150F, 100F, 150F, 200F, 50F, 200F, 50F, 100F)
    private val points1: FloatArray = floatArrayOf(300F, 200F, 600F, 200F, 300F, 300F, 600F, 300F, 400F, 100F, 400F, 400F, 500F, 100F, 500F, 400F)

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        canvas.drawARGB(80, 102, 204, 255)

        p.color = Color.RED
        p.strokeWidth = 10F

        canvas.drawPoints(points, p)
        canvas.drawLines(points1, p)

        p.color = Color.GREEN

        canvas.drawRoundRect(rectf, 20F, 20F, p)

        rectf.offset(0F, 150F)
        canvas.drawOval(rectf, p)

        rectf.offsetTo(900F, 100F)
        rectf.inset(0F, -25F)
        canvas.drawArc(rectf, 90F, 270F, true, p)

        rectf.offset(0F, 150F)
        canvas.drawArc(rectf, 90F, 270F, false, p)

        p.strokeWidth = 3F
        canvas.drawLine(150F, 450F, 150F, 600F, p)
        p.color = Color.BLUE

        canvas.drawText("text left", 150F, 500F, p)

        p.textAlign = Paint.Align.CENTER

        canvas.drawText("text center", 150F, 525F, p)

        p.textAlign = Paint.Align.RIGHT

        canvas.drawText("text right", 150F, 550F, p)

    }
}