package com.example.bss_mobile_lab_6_7

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.bss_mobile_lab_6_7.draw_utils.DrawView

class MainActivity : Activity() {
    var view: DrawView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = DrawView(this)

        setContentView(view)
    }
}
