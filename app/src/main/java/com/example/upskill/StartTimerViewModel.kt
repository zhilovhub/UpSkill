package com.example.upskill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class StartTimerViewModel : ViewModel() {

    private val _currentTime = MutableLiveData<Long>(83)
    val currentTime: LiveData<Long>
        get() = _currentTime

}
