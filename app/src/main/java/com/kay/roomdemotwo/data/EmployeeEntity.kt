package com.kay.roomdemotwo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employeeTable")
data class EmployeeEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        @ColumnInfo(name = "email-id")
        val email: String
)

