package com.kay.roomdemotwo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kay.roomdemotwo.data.EmployeeEntity

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDatabaseEmpty(employeeData: List<EmployeeEntity>) {
        emptyDatabase.value = employeeData.isEmpty()
    }

    /** ======================== Add/Update Fragment ============================================== */

    // function that checks if the input is empty
    fun verifyDataFromUser(name: String, email: String): Boolean {
        return !(name.isEmpty() || email.isEmpty())
    }
}
