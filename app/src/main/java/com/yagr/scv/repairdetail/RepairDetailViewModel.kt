package com.yagr.scv.repairdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import com.yagr.scv.data.AppDatabase
import com.yagr.scv.data.steps.Step

class RepairDetailViewModel(application: Application, savedStateHandle: SavedStateHandle) : AndroidViewModel(application) {
    private val stepDao = AppDatabase.getInstance(application).stepDao()
    // TODO hardcoding "repairId" here does not look good. What should it be replaced with?
    val steps = stepDao.getStepsForRepair(savedStateHandle.get<Long>("repairId")!!)
}