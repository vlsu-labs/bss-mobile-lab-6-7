package com.example.bss_mobile_lab_6_7

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.bss_mobile_lab_6_7.draw_utils.DrawView

class MainActivity : Activity(), OnTouchListener {

    val stringBuilder: StringBuilder = StringBuilder()
    var tv: TextView? = null
    var upPi = 0
    var downPi = 0
    var inTouch = false
    var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv = TextView(this)
        tv!!.textSize = 30F
        tv!!.setOnTouchListener(this)

        setContentView(tv)
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        if (p0 == null || p1 == null) {
            return false
        }

        var actionMask = p1.actionMasked
        var pointerIndex = p1.actionIndex
        var pointerCount = p1.pointerCount

        when (actionMask) {
            MotionEvent.ACTION_DOWN -> inTouch = true
            MotionEvent.ACTION_POINTER_DOWN -> downPi = pointerIndex
            MotionEvent.ACTION_UP -> {
                inTouch = false
                stringBuilder.setLength(0)
            }
            MotionEvent.ACTION_POINTER_UP -> upPi = pointerIndex
            MotionEvent.ACTION_MOVE -> {
                stringBuilder.setLength(0)

                for (i in 1 until 10) {
                    stringBuilder.append("Index = $i")

                    if (i < pointerCount) {
                        stringBuilder.append(", ID = ${p1.getPointerId(i)}")
                        stringBuilder.append(", X = ${p1.getX(i)}")
                        stringBuilder.append(", Y = ${p1.getY(i)}")
                    } else {
                        stringBuilder.append(", ID = ")
                        stringBuilder.append(", X = ")
                        stringBuilder.append(", Y = ")
                    }
                    stringBuilder.append("\n")
                }
            }
        }

        result = "down: $downPi \nup: $upPi \n"

        if (inTouch) {
            result += "pointerCount: $pointerCount \n $stringBuilder"
        }

        tv!!.text = result

        return true
    }


}
