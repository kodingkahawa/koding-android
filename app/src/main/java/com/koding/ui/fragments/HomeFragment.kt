package com.koding.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.koding.data.Student
import com.koding.data.StudentsDatabase
import com.koding.koding.R
import com.koding.koding.databinding.FragmentHomeBinding
import com.koding.viewmodel.MainViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val userName = binding.userName.text.toString()
            val userAge = binding.userAge.text.toString()
            when {
                userName.isNullOrEmpty() -> {
                    Toast.makeText(context, "Enter Your Name", Toast.LENGTH_LONG).show()
                }
                userAge.isNullOrEmpty() -> {
                    Toast.makeText(context, "Enter your Age", Toast.LENGTH_LONG).show()
                }
                else -> {
                    viewModel.saveStudent(Student(userName = userName, userAge = userAge.toInt()))
                }
            }
        }
    }

}