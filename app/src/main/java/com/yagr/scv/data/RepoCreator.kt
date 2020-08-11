package com.yagr.scv.data

import android.content.Context

object RepoCreator {
    fun createRepairRepo(context: Context): RepairRepository =
        RepairRepositoryImpl(AppDatabase.getInstance(context).repairDao())
}