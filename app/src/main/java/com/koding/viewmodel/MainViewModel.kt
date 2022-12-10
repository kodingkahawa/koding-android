package com.koding.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koding.data.Student
import com.koding.data.StudentsDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = StudentsDatabase.getInstance(application)

    private val _students = MutableLiveData<List<Student>>()

    val students: LiveData<List<Student>> = _students


    fun getStudents() {
        viewModelScope.launch {
            val list = db.studentsDao().getStudents()
            _students.value = list
        }
    }

    fun saveStudent(student: Student) {
        viewModelScope.launch {
            db.studentsDao().saveStudent(student)
        }
    }
}