package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup

class MyDetailsLookup(
        private val recyclerView: RecyclerView
) : ItemDetailsLookup<Item>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Item>? = recyclerView.findChildViewUnder(
            e.x,
            e.y
    )?.let {
        (recyclerView.getChildViewHolder(it) as? ItemViewHolder)?.getItemDetails()
    }
}