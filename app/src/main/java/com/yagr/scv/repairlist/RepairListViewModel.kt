package com.yagr.scv.repairlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yagr.scv.data.RepoCreator

class RepairListViewModel(application: Application) : AndroidViewModel(application) {
    private val repairRepo = RepoCreator.createRepairRepo(application)
    val repairs = repairRepo.getRepairs()
}