package com.example.upskill.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.upskill.media.RingtoneHelper
import com.example.upskill.media.VibratorHelper
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class ViewModelModule(
    private val context: Context
) {

    @Provides
    fun provideRingtoneHelper(): RingtoneHelper {
        return RingtoneHelper(context)
    }

    @Provides
    fun provideVibratorHelper(): VibratorHelper {
        return VibratorHelper(context)
    }

}