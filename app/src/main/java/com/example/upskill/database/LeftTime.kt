package com.example.upskill.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("left_time")
data class LeftTime(
    @PrimaryKey
    @ColumnInfo(name = "skillName")
    val skillName: String,

    @ColumnInfo(name = "time")
    val time: String
)