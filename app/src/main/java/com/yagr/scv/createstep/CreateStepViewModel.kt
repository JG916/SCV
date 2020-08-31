package com.yagr.scv.createstep

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yagr.scv.data.AppDatabase

class CreateStepViewModel(application: Application) : AndroidViewModel(application) {
    private val stepDao = AppDatabase.getInstance(application).stepDao()

    val status = MutableLiveData<StepCreationStatus>()

    fun createTapped() {
       TODO()
    }

    enum class StepCreationStatus {
        SUCCESS
        // TODO Add ERROR
    }
}