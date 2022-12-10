package com.koding.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentsDao {
    @Insert
    fun saveStudent(student: Student)

    @Insert
    fun saveStudents(student: List<Student>)

    @Query("SELECT * from students_table")
    fun getStudents(): List<Student>

    @Query("SELECT * from students_table WHERE userName =:firstName ")
    fun getStudent(firstName: String): Student

    @Update
    fun updateStudent(student: Student)

    @Delete
    fun deleteStudent(students: Student)
}