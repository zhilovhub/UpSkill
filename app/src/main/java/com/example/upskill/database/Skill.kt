package com.example.upskill.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("skill_table")
data class Skill(
    @PrimaryKey
    @ColumnInfo(name = "skill_name")
    val skillName: String,

    @ColumnInfo(name = "time")
    val time: String
)