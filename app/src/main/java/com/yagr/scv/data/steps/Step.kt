package com.yagr.scv.data.steps

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "steps")
data class Step(
    val name: String,
    var order: Int,
    var parts: List<String>?,
    val repairId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}