package com.example.bss_mobile_lab_6_7

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.bss_mobile_lab_6_7.draw_utils.DrawView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }
}
