package com.yagr.scv.createrepair

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yagr.scv.data.Repair
import com.yagr.scv.data.RepoCreator
import com.yagr.scv.extensions.nullIfBlank
import kotlinx.coroutines.launch

class CreateRepairViewModel(application: Application) : AndroidViewModel(application) {
    private val repairRepo = RepoCreator.createRepairRepo(application)

    val name = MutableLiveData("")
    val description = MutableLiveData("")

     fun createTapped() {
        val repair = Repair(name.value!!, description.value?.nullIfBlank())

         viewModelScope.launch {
             repairRepo.saveRepair(repair)
         }
    }
}