package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup

class BookDetailsLookup(
        private val recyclerView: RecyclerView
) : ItemDetailsLookup<Book>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Book>? = recyclerView.findChildViewUnder(
            e.x,
            e.y
    )?.let {
        (recyclerView.getChildViewHolder(it) as? BookViewHolder)?.getItemDetails()
    }
}