package com.yagr.scv.data.steps

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StepDao {
    @Query("SELECT * FROM steps WHERE repairId = :repairId")
    fun getStepsForRepair(repairId: Long): LiveData<List<Step>>

    @Insert
    suspend fun insertStep(step: Step): Long

    @Delete
    suspend fun deleteStep(step: Step)
}