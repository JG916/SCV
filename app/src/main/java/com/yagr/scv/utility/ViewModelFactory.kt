package com.yagr.scv.utility

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.yagr.scv.createrepair.CreateRepairViewModel
import com.yagr.scv.repairdetail.RepairDetailViewModel
import com.yagr.scv.repairlist.RepairListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val application: Application,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(RepairListViewModel::class.java) ->
                RepairListViewModel(application)
            isAssignableFrom(CreateRepairViewModel::class.java) ->
                CreateRepairViewModel(application)
            isAssignableFrom(RepairDetailViewModel::class.java) ->
                RepairDetailViewModel(application, handle)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}