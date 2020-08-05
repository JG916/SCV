package com.yagr.scv.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepairDao {
    @Query("SELECT * FROM repairs")
    fun getRepairs(): LiveData<List<Repair>>

    @Insert
    suspend fun insertRepair(repair: Repair): Long

    @Delete
    suspend fun deleteRepair(repair: Repair)
}