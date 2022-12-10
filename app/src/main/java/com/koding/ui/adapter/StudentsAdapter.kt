package com.koding.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koding.data.Student
import com.koding.koding.databinding.ItemStudentBinding

class StudentsAdapter(val studentList: List<Student>) :
    RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>() {
    class StudentsViewHolder(val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val student = studentList[position]

        holder.binding.tvUserName.text = student.userName
        holder.binding.tvUserAge.text = student.userAge.toString()
    }

    override fun getItemCount(): Int = studentList.size
}