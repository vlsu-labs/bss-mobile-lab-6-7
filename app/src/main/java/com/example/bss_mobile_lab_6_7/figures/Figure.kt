package com.example.bss_mobile_lab_6_7.figures

import android.graphics.Canvas
import android.graphics.Paint

interface IFigure {
    suspend fun draw(canvas: Canvas, paint: Paint)
}