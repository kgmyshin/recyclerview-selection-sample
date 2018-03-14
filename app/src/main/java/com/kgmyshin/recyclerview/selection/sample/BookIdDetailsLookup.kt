package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup

class BookIdDetailsLookup(
        private val recyclerView: RecyclerView
) : ItemDetailsLookup<Long>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? = recyclerView.findChildViewUnder(
            e.x,
            e.y
    )?.let {
        (recyclerView.getChildViewHolder(it) as? BookViewHolder)?.getItemIdDetails()
    }
}