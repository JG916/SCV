package com.yagr.scv.data

import androidx.lifecycle.LiveData

interface RepairRepository {
    fun getRepairs(): LiveData<List<Repair>>
    fun saveRepair(repair: Repair)
    fun deleteRepair(repair: Repair)
    fun updateRepair(repair: Repair)
}

class RepairRepositoryImpl(private val dao: RepairDao) : RepairRepository {

    override fun getRepairs(): LiveData<List<Repair>> {
        return dao.getRepairs()
    }

    override fun saveRepair(repair: Repair) {
        TODO("Not yet implemented")
    }

    override fun deleteRepair(repair: Repair) {
        TODO("Not yet implemented")
    }

    override fun updateRepair(repair: Repair) {
        TODO("Not yet implemented")
    }

}