package com.yagr.scv.bindings

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.data.steps.Step
import com.yagr.scv.repairdetail.StepListAdapter
import com.yagr.scv.repairlist.RepairListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("repairItems")
fun bindRepairs(view: RecyclerView, items: List<Repair>?) {
    items?.let {
        (view.adapter as RepairListAdapter).updateItems(items)
    }
}

@BindingAdapter("stepItems")
fun bindSteps(view: RecyclerView, items: List<Step>?) {
    items?.let {
        (view.adapter as StepListAdapter).updateItems(items)
    }
}

@BindingAdapter("stepParts")
fun bindStepParts(view: TextView, parts: List<String>?) {
    view.text = parts?.joinToString()
}