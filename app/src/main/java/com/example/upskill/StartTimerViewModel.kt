package com.example.upskill

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class StartTimerViewModel : ViewModel() {

    private var globalTime = 8000L

    private val _currentTime = MutableLiveData(globalTime)
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val _timerState = MutableLiveData(TimerState.STOPPED)
    val timerState: LiveData<TimerState>
        get() = _timerState

    private lateinit var timer: CountDownTimer

    fun startTimer() {
        globalTime = 8000L
        timer = createTimer()
        timer.start()
        _timerState.value = TimerState.RUNNING
    }

    fun pauseTimer() {
        timer.cancel()
        timer = createTimer()
        _timerState.value = TimerState.PAUSED
    }

    fun continueTimer() {
        timer.start()
        _timerState.value = TimerState.RUNNING
    }

    fun stopTimer() {
        timer.cancel()
        _timerState.value = TimerState.STOPPED
        _currentTime.value = 0L
    }

    private fun createTimer(): CountDownTimer {
        _currentTime.value = globalTime

        return object : CountDownTimer(globalTime, 1000) {
            override fun onTick(p0: Long) {
                globalTime = p0
                _currentTime.value = p0
            }

            override fun onFinish() {
                _timerState.value = TimerState.STOPPED
            }
        }
    }

}
