package com.kay.roomdemotwo.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kay.roomdemotwo.data.EmployeeEntity

class EmployeeRecyclerViewDiffUtil(
    private val oldList: List<EmployeeEntity>,
    private val newList: List<EmployeeEntity>
) : DiffUtil.Callback() {

    // it returns the size of the old list
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].name == newList[newItemPosition].name &&
                oldList[oldItemPosition].email == newList[newItemPosition].email

    }
}
