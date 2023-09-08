package com.example.upskill.di

import com.example.upskill.StartTimerFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: StartTimerFragment)

}
