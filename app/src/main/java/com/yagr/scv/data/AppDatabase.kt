package com.yagr.scv.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.data.repairs.RepairDao
import com.yagr.scv.data.steps.Step
import com.yagr.scv.data.steps.StepDao


@Database(entities = [Repair::class, Step::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repairDao(): RepairDao
    abstract fun stepDao(): StepDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, "scv-db")
                .build()
        }
    }
}