package com.example.upskill.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Skill::class], version = 1, exportSchema = false)
abstract class SkillRoomDatabase : RoomDatabase() {

    abstract fun skillDao(): SkillDao

    companion object {

        @Volatile
        private var INSTANCE: SkillRoomDatabase? = null

        fun getDatabase(context: Context): SkillRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SkillRoomDatabase::class.java,
                    "skill_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}