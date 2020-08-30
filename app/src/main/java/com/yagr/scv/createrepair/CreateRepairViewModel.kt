package com.yagr.scv.createrepair

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.data.RepoCreator
import com.yagr.scv.extensions.nullIfBlank
import kotlinx.coroutines.launch

class CreateRepairViewModel(application: Application) : AndroidViewModel(application) {
    private val repairRepo = RepoCreator.createRepairRepo(application)

    val name = MutableLiveData("")
    val description = MutableLiveData("")

    val status = MutableLiveData<RepairCreationStatus>()

    fun createTapped() {
        val repair = Repair(
            name.value!!,
            description.value?.nullIfBlank()
        )

        viewModelScope.launch {
            repairRepo.saveRepair(repair)
            status.value = RepairCreationStatus.SUCCESS
        }
    }

    enum class RepairCreationStatus {
        SUCCESS
        // TODO Add ERROR
    }
}