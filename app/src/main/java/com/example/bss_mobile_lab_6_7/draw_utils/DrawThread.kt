package com.example.bss_mobile_lab_6_7.draw_utils

import android.view.SurfaceHolder
import android.graphics.Canvas;
import android.graphics.Color;

class DrawThread(private var surfaceHolder: SurfaceHolder) : Thread() {

    private var running: Boolean = false;

    fun setRunning(running: Boolean) {
        this.running = running;
    }

    override fun run() {
        var canvas: Canvas?;
        while (running) {
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas(null);
                if (canvas == null) {
                    continue;
                }
                canvas.drawColor(Color.GREEN);
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}