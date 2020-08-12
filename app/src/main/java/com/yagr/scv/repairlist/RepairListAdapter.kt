package com.yagr.scv.repairlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yagr.scv.data.Repair
import com.yagr.scv.databinding.ItemRepairBinding

class RepairListAdapter : RecyclerView.Adapter<RepairListAdapter.RepairViewHolder>() {

    private val items = mutableListOf<Repair>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = items.size

    fun updateItems(repairs: List<Repair>) {
        items.clear()
        items.addAll(repairs)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RepairViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class RepairViewHolder(val binding: ItemRepairBinding) : RecyclerView.ViewHolder(binding.root)

}
