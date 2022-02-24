package com.kay.roomdemotwo.repository

import androidx.lifecycle.LiveData
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.model.EmployeeDao

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val getAllData: LiveData<List<EmployeeEntity>> = employeeDao.fetchAllEmployees()

    suspend fun insert(employeeEntity: EmployeeEntity) {
        employeeDao.insert(employeeEntity)
    }
}
