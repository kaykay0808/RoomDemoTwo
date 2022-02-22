package com.kay.roomdemotwo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kay.roomdemotwo.ItemAdapter
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.databinding.FragmentEmployeeListBinding
import com.kay.roomdemotwo.model.EmployeeDao
import com.kay.roomdemotwo.model.EmployeeViewModel
import kotlinx.coroutines.launch

class EmployeeListFragment : Fragment() {

    private var _binding: FragmentEmployeeListBinding? = null
    private val binding get() = _binding!!

    private val employeeViewModel : EmployeeViewModel by viewModels()

    private val adapter: ItemAdapter by lazy { ItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //recycler view
        recyclerViewSetup()
        binding.btnAdd.setOnClickListener {
            addRecord()
        }
    }

    private fun recyclerViewSetup() {
        val recyclerView = binding.rvItemsList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun addRecord() {
        val name = binding.editTextName.text.toString()
        val email = binding.etEmailId.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty()) {
            lifecycleScope.launch {
                val newData = EmployeeEntity(0, name, email)
                Toast.makeText(
                    context,
                    "Record saved",
                    Toast.LENGTH_LONG
                ).show()
                employeeViewModel.insertData(newData)
                // after you added new data it's clear the field
                binding.editTextName.text.clear()
                binding.etEmailId.text.clear()
            }
        } else {
          Toast.makeText(
              context,
              "Please fill out all fields",
              Toast.LENGTH_LONG
          ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}