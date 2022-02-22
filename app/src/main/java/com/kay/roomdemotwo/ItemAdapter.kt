package com.kay.roomdemotwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.databinding.ItemsRowBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    var items = mutableListOf<EmployeeEntity>()

    class ViewHolder (val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root){

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
        holder.binding.LinearLayoutRow
        holder.binding.tvName
        holder.binding.tvEmail
        holder.binding.ivEdit
        holder.binding.ivDelete
    }

    override fun getItemCount(): Int {
        return items.size
    }
}