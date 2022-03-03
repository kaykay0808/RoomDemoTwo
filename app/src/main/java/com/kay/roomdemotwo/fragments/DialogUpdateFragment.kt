package com.kay.roomdemotwo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kay.roomdemotwo.R
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.databinding.FragmentDialogUpdateBinding
import com.kay.roomdemotwo.model.EmployeeViewModel
import com.kay.roomdemotwo.model.SharedViewModel

class DialogUpdateFragment : Fragment() {

    private var _binding: FragmentDialogUpdateBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DialogUpdateFragmentArgs>()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Passing data from listFragment to updateFragment
        binding.etUpdateName.setText(args.currentItem.name)
        binding.etUpdateEmailId.setText(args.currentItem.email)
        binding.tvUpdate.setOnClickListener {
            updateItem()
        }
    }

    private fun updateItem() {
        val name = binding.etUpdateName.text.toString()
        val email = binding.etUpdateEmailId.text.toString()

        val validation = sharedViewModel.verifyDataFromUser(name, email)
        if (validation) {
            // Update current Item
            val updatedItem = EmployeeEntity(
                args.currentItem.id,
                name,
                email
            )
            employeeViewModel.updateData(updatedItem)
            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_SHORT).show()
            // Navigate back
            findNavController().navigate(R.id.action_dialogUpdateFragment_to_employeeListFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
