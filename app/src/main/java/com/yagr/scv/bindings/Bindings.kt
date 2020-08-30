package com.yagr.scv.bindings

import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.repairlist.RepairListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("repairItems")
fun bindAdapter(view: RecyclerView, items: List<Repair>?) {
    items?.let {
        (view.adapter as RepairListAdapter).updateItems(items)
    }
}