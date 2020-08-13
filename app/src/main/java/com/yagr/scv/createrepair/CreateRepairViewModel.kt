package com.yagr.scv.createrepair

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yagr.scv.data.RepoCreator

class CreateRepairViewModel(application: Application) : AndroidViewModel(application) {
    private val repairRepo = RepoCreator.createRepairRepo(application)

    val name = MutableLiveData("")
    val description = MutableLiveData("")

}