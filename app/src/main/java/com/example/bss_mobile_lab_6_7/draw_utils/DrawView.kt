package com.example.bss_mobile_lab_6_7.draw_utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import com.example.bss_mobile_lab_6_7.figures.Hexagon
import com.example.bss_mobile_lab_6_7.figures.Pentagon
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DrawView(context: Context): View(context) {
    private val p: Paint = Paint()
    private var touchPath: Path? = null
    private var c: Canvas? = null
    private var qmap: MutableMap<Int, MutableList<Path>> = HashMap()
    private var active: MutableMap<Int, Boolean> = HashMap()
    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        canvas.drawARGB(80, 102, 204, 255)

        var pLine = Paint()
        pLine.color = Color.GREEN
        pLine.isAntiAlias = true
        pLine.style = Paint.Style.STROKE
        pLine.strokeWidth = 12F

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

        for (value in qmap.values) {
            for (path in value) {
                canvas.drawPath(path, pLine)
            }
        }


    }

    private fun startTracking(index: Int, touchX: Float, touchY: Float) {
        if (!qmap.containsKey(index)) {
            qmap[index] = ArrayList()
            qmap[index]?.add(Path())
        }
        qmap[index]?.last()?.moveTo(touchX, touchY)
    }

    private fun overTracking(index: Int, touchX: Float, touchY: Float) {
        qmap[index]?.last()?.lineTo(touchX, touchY)
        qmap[index]?.add(Path())
    }

    private fun tracking(index: Int, touchX: Float, touchY: Float) {
        if (!qmap.containsKey(index)) {
            startTracking(index, touchX, touchY)
            return
        }

        qmap[index]?.last()?.lineTo(touchX, touchY)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y
        val index = event.getPointerId(0)
        when (event.action) {
            MotionEvent.ACTION_POINTER_DOWN -> {
                startTracking(index, touchX, touchY)
            }
            MotionEvent.ACTION_DOWN -> {
                startTracking(index, touchX, touchY)
            }
            MotionEvent.ACTION_POINTER_UP -> {
                overTracking(index, touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                for (i in 0 until event.pointerCount) {

                    var moveX = event.getX(i)
                    var moveY = event.getY(i)
                    var trackId = event.getPointerId(i)
                    tracking(trackId, moveX, moveY)
                }
            }
            MotionEvent.ACTION_UP -> {
                overTracking(index, touchX, touchY)
            }

            else -> return false
        }
        invalidate()
        return true
    }
}