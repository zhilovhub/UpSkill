package com.example.upskill

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.upskill.database.SkillDao
import com.example.upskill.database.SkillRoomDatabase
import com.example.upskill.media.RingtoneHelper
import com.example.upskill.media.VibratorHelper


class StartTimerViewModel(
    private val ringtoneHelper: RingtoneHelper,
    private val vibratorHelper: VibratorHelper,
    private val skillDao: SkillDao
) : ViewModel() {

    private var globalTime = 8000L

    private val _currentTime = MutableLiveData(globalTime)
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val _timerState = MutableLiveData(TimerState.INITIALIZED)
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
        ringtoneHelper.stop()
        vibratorHelper.stop()
        _timerState.value = TimerState.INITIALIZED
        _currentTime.value = 8000L
        globalTime = 8000L
    }

    private fun createTimer(): CountDownTimer {
        _currentTime.value = globalTime

        return object : CountDownTimer(globalTime, 1000) {
            override fun onTick(p0: Long) {
                globalTime = p0
                _currentTime.value = p0
            }

            override fun onFinish() {
                _timerState.value = TimerState.FINISHED
                ringtoneHelper.start()
                vibratorHelper.start()
            }
        }
    }

    companion object {
        fun Factory(context: Context) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val ringtoneHelper = RingtoneHelper(context)
                val vibratorHelper = VibratorHelper(context)
                val skillDao = SkillRoomDatabase.getDatabase(context).skillDao()
                return StartTimerViewModel(ringtoneHelper, vibratorHelper, skillDao) as T
            }
        }

    }

}
