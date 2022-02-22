package com.kay.roomdemotwo.repository

import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.model.EmployeeDao

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    suspend fun insert(employeeEntity: EmployeeEntity) {
        employeeDao.insert(employeeEntity)
    }

}