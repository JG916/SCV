package com.yagr.scv.createrepair

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yagr.scv.data.AppDatabase
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.extensions.nullIfBlank
import kotlinx.coroutines.launch

class CreateRepairViewModel(application: Application) : AndroidViewModel(application) {
    private val repairDao = AppDatabase.getInstance(application).repairDao()

    val name = MutableLiveData("")
    val description = MutableLiveData("")

    val status = MutableLiveData<RepairCreationStatus>()

    fun createTapped() {
        val repair = Repair(
            name.value!!,
            description.value?.nullIfBlank()
        )

        viewModelScope.launch {
            repairDao.insertRepair(repair)
            status.value = RepairCreationStatus.SUCCESS
        }
    }

    enum class RepairCreationStatus {
        SUCCESS
        // TODO Add ERROR
    }
}