package com.example.bss_mobile_lab_6_7.draw_utils

import android.view.SurfaceView
import android.content.Context
import android.view.SurfaceHolder

class DrawView: SurfaceView, SurfaceHolder.Callback {

    private lateinit var drawThread: DrawThread

    constructor(context: Context) : super(context) {
        holder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        drawThread = DrawThread(holder)
        drawThread.setRunning(true)
        drawThread.start()
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        var retry: Boolean = true
        drawThread.setRunning(false)
        while (retry) {
            try {
                drawThread.join()
                retry = false
            } catch (e: InterruptedException) {

            }
        }
    }
}