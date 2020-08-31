package com.yagr.scv.repairdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yagr.scv.data.steps.Step
import com.yagr.scv.databinding.ItemStepBinding

class StepListAdapter :
    RecyclerView.Adapter<StepListAdapter.StepViewHolder>() {

    private val items = mutableListOf<Step>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStepBinding.inflate(inflater, parent, false)
        return StepViewHolder(binding)
    }

    override fun getItemCount() = items.size

    fun updateItems(steps: List<Step>) {
        items.clear()
        items.addAll(steps)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val step = items[position]
        holder.binding.step = step
    }

    class StepViewHolder(val binding: ItemStepBinding) : RecyclerView.ViewHolder(binding.root)

}