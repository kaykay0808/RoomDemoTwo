package com.kay.roomdemotwo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kay.roomdemotwo.data.EmployeeEntity

@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    // reading data / retrieving data?
    @Query("SELECT * FROM 'employeeTable'")
    fun fetchAllEmployees(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM 'employeeTable' where id=:id")
    fun fetchEmployeeById(id: Int): LiveData<EmployeeEntity>
}
