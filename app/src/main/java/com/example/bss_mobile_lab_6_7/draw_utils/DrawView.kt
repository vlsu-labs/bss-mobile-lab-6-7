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
    private val rect: Rect = Rect(100, 200, 200, 300)
    private val sb: StringBuilder = StringBuilder()

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        canvas.drawARGB(80, 102, 204, 255)

        p.color = Color.BLUE
        p.strokeWidth = 10F

        p.textSize = 30F

        sb.setLength(0)
        sb
            .append("width = ")
            .append(canvas.width)
            .append(", height = ")
            .append(canvas.height)
        canvas.drawText(sb.toString(), 100F, 100F, p)

        p.style = Paint.Style.FILL
        canvas.drawRect(rect, p)

        p.style = Paint.Style.STROKE
        rect.offset(150, 0)
        canvas.drawRect(rect, p)

        p.style = Paint.Style.FILL_AND_STROKE
        rect.offset(150, 0)
        canvas.drawRect(rect, p)



    }
}