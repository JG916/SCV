package com.yagr.scv.repairlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.databinding.ItemRepairBinding

class RepairListAdapter(private val listener: RepairItemClickListener) :
    RecyclerView.Adapter<RepairListAdapter.RepairViewHolder>() {

    interface RepairItemClickListener {
        fun onRepairClicked(repair: Repair)
    }

    private val items = mutableListOf<Repair>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepairBinding.inflate(inflater, parent, false)
        val viewHolder = RepairViewHolder(binding)

        binding.root.setOnClickListener {
            val repair = items[viewHolder.adapterPosition]
            listener.onRepairClicked(repair)
        }

        return viewHolder
    }

    override fun getItemCount() = items.size

    fun updateItems(repairs: List<Repair>) {
        items.clear()
        items.addAll(repairs)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RepairViewHolder, position: Int) {
        holder.binding.repair = items[position]
    }

    class RepairViewHolder(val binding: ItemRepairBinding) : RecyclerView.ViewHolder(binding.root)

}
