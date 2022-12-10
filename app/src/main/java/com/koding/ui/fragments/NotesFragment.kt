package com.koding.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.koding.data.StudentsDatabase
import com.koding.koding.R
import com.koding.koding.databinding.FragmentNotesBinding
import com.koding.ui.adapter.StudentsAdapter
import com.koding.viewmodel.MainViewModel

class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private lateinit var studentsAdapter: StudentsAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getStudents()

        viewModel.students.observe(viewLifecycleOwner) {

            studentsAdapter = StudentsAdapter(it)

            binding.recyclerviewStudents.adapter = studentsAdapter
        }

        binding.recyclerviewStudents.layoutManager =
            LinearLayoutManager(context)
    }

}