package com.yagr.scv.repairlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yagr.scv.data.AppDatabase

class RepairListViewModel(application: Application) : AndroidViewModel(application) {
    private val repairDao = AppDatabase.getInstance(application).repairDao()
    val repairs = repairDao.getRepairs()
}