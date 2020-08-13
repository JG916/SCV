package com.yagr.scv.data

import androidx.lifecycle.LiveData

interface RepairRepository {
    fun getRepairs(): LiveData<List<Repair>>
    suspend fun saveRepair(repair: Repair)
    fun deleteRepair(repair: Repair)
    fun updateRepair(repair: Repair)
}

class RepairRepositoryImpl(private val dao: RepairDao) : RepairRepository {

    override fun getRepairs(): LiveData<List<Repair>> {
        return dao.getRepairs()
    }

    override suspend fun saveRepair(repair: Repair) {
        dao.insertRepair(repair)
    }

    override fun deleteRepair(repair: Repair) {
        TODO("Not yet implemented")
    }

    override fun updateRepair(repair: Repair) {
        TODO("Not yet implemented")
    }

}