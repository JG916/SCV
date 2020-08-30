package com.yagr.scv.data.repairs

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repairs")
data class Repair(
    @ColumnInfo val name: String,
    @ColumnInfo val description: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var repairId: Long = 0
}