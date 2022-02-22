package com.kay.roomdemotwo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kay.roomdemotwo.data.EmployeeDatabase
import com.kay.roomdemotwo.data.EmployeeEntity
import com.kay.roomdemotwo.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeDao = EmployeeDatabase.getInstance(application).employeeDao()
    private val repository: EmployeeRepository = EmployeeRepository(employeeDao)

    fun insertData(employeeEntity: EmployeeEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(employeeEntity)
        }
    }
}