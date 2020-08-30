package com.yagr.scv.data.steps

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yagr.scv.data.repairs.Repair

@Dao
interface StepDao {
    @Query("SELECT * FROM steps WHERE repairId = :repairId")
    fun getStepsForRepair(repairId: String): LiveData<List<Step>>

    @Insert
    suspend fun insertStep(step: Repair): Long

    @Delete
    suspend fun deleteStep(step: Repair)
}