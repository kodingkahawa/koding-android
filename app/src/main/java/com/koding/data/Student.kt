package com.koding.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Student(
    val userName: String,
    val userAge: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)