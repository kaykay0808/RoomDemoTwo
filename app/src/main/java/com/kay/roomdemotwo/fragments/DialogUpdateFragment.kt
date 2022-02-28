package com.kay.roomdemotwo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kay.roomdemotwo.R
import com.kay.roomdemotwo.databinding.FragmentDialogUpdateBinding
import com.kay.roomdemotwo.databinding.FragmentEmployeeListBinding
import com.kay.roomdemotwo.model.EmployeeViewModel
import com.kay.roomdemotwo.model.SharedViewModel

class DialogUpdateFragment : Fragment() {

    private var _binding: FragmentDialogUpdateBinding? = null
    private val binding get() = _binding!!

    private val employeeViewModel: EmployeeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDialogUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }
}