package com.example.upskill.di

import android.content.Context
import com.example.upskill.database.SkillDao
import com.example.upskill.database.SkillRoomDatabase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule(
    private val context: Context
) {

    @Provides
    fun provideSkillDao(): SkillDao {
        return SkillRoomDatabase.getDatabase(context).skillDao()
    }

}