package com.example.bss_mobile_lab_6_7.draw_utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import com.example.bss_mobile_lab_6_7.figures.Hexagon
import com.example.bss_mobile_lab_6_7.figures.Pentagon
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DrawView(context: Context): View(context) {
    private val p: Paint = Paint()
    private val sb: StringBuilder = StringBuilder()

    fun drawTriangle(canvas: Canvas, paint: Paint?, x: Float, y: Float, width: Float) {
        val halfWidth = width / 2
        val path = Path()
        path.moveTo(x, y - halfWidth) // Top
        path.lineTo(x - halfWidth, y + halfWidth) // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth) // Bottom right
        path.lineTo(x, y - halfWidth) // Back to Top
        path.close()
        canvas.drawPath(path, paint!!)
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        canvas.drawARGB(80, 102, 204, 255)

        p.color = Color.BLUE
        p.strokeWidth = 10F

        p.textSize = 30F

        var width = 300F
        var center = Pair(400F, 400F)

        var ptg = Pentagon(center, width)
        width = 200F
        var hxg = Hexagon(center, width)

        GlobalScope.launch {
            ptg.draw(canvas, p)
            p.color = Color.RED
            hxg.draw(canvas, p)
        }


    }
}