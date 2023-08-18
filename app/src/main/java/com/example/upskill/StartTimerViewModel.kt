package com.example.upskill

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class StartTimerViewModel : ViewModel() {

    private var time = 15000L

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val _isRunning = MutableLiveData(false)
    val isRunning: LiveData<Boolean>
        get() = _isRunning

    private lateinit var timer: CountDownTimer

    fun startTimer() {
        timer = createTimer(time)
        timer.start()
        _isRunning.value = true
    }

    private fun createTimer(time: Long): CountDownTimer {
        _currentTime.value = time

        return object : CountDownTimer(time, 1000) {
            override fun onTick(p0: Long) {
                _currentTime.value = p0
            }

            override fun onFinish() {
                _isRunning.value = false
            }
        }
    }

}
