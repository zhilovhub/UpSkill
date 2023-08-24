package com.example.upskill.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SkillDao {

    @Query("SELECT * FROM skill_table WHERE skill_name = :skillName")
    fun getSkill(skillName: String): Skill

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(skill: Skill)

    @Query("DELETE FROM skill_table")
    suspend fun deleteAll()

}