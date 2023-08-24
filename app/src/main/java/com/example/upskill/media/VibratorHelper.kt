package com.example.upskill.media

import android.content.Context
import android.os.Vibrator

class VibratorHelper(private val context: Context) {

    private var vibrator: Vibrator? = null

    fun start() {
        vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        vibrator?.vibrate(longArrayOf(200, 200, 200, 400), 0)
    }

    fun stop() {
        vibrator?.cancel()
    }

}