package com.yagr.scv.bindings

import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}