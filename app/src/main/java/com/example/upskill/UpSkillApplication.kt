package com.example.upskill

import android.app.Application
import com.example.upskill.di.AppComponent
import com.example.upskill.di.DaggerAppComponent

class UpSkillApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()

}