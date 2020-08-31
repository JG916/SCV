package com.yagr.scv.repairdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yagr.scv.data.AppDatabase
import com.yagr.scv.data.steps.Step

class RepairDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val stepDao = AppDatabase.getInstance(application).stepDao()
    val steps = emptyList<Step>()
}