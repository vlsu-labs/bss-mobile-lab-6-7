package com.example.bss_mobile_lab_6_7.draw_utils

import android.view.SurfaceView
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.SurfaceHolder
import android.view.View

class DrawView(context: Context): View(context) {
    private val p: Paint = Paint()
    private val rect: Rect = Rect()

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        canvas.drawARGB(80, 102, 204, 255)

        p.color = Color.RED
        p.strokeWidth = 10F

        canvas.drawPoint(50F, 50F, p)
        canvas.drawLine(100F, 100F, 500F, 50F, p)
        canvas.drawCircle(100F, 200F, 50F, p)
        canvas.drawRect(200F, 150F, 400F, 200F, p)

        rect.set(250, 300, 350, 500)
        canvas.drawRect(rect, p)

    }
}