package com.kay.roomdemotwo.fragments.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kay.roomdemotwo.R
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.databinding.ItemsRowBinding
import com.kay.roomdemotwo.fragments.DialogUpdateFragmentArgs
import com.kay.roomdemotwo.fragments.EmployeeListFragmentDirections
import com.kay.roomdemotwo.model.EmployeeViewModel
import com.kay.roomdemotwo.model.SharedViewModel

class ItemAdapter(val deleteFun: (EmployeeEntity) -> Unit)  : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // (private val updateListener: (id:Int) -> Unit, private val deleteListener:(id:Int) -> Unit)
    var items = emptyList<EmployeeEntity>()

    class ViewHolder(val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        val linearLayoutRow = binding.LinearLayoutRow
        val tvName = binding.tvName
        val tvEmail = binding.tvEmail
        val ivEdit = binding.ivEdit
        val ivDelete = binding.ivDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(ItemsRowBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.ivEdit.setOnClickListener{
            val action =
                EmployeeListFragmentDirections.actionEmployeeListFragmentToDialogUpdateFragment(items[position])
          holder.itemView.findNavController().navigate(action)
        }
        holder.ivDelete.setOnClickListener{
            deleteFun(item)
        }

        // change the background color of the linearLayout
        // %2 means every second items
        if (position % 2 == 0) {
            holder.linearLayoutRow.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.lightGray
                )
            )
        } else {
            holder.linearLayoutRow.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.white
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(employeeEntity: List<EmployeeEntity>) {
        val employeeDiffUtil = EmployeeRecyclerViewDiffUtil(items, employeeEntity)
        val toDoDiffResult = DiffUtil.calculateDiff(employeeDiffUtil)
        this.items = employeeEntity
        toDoDiffResult.dispatchUpdatesTo(this)
    }
}
