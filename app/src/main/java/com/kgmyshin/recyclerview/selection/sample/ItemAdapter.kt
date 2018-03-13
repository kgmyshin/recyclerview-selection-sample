package com.kgmyshin.recyclerview.selection.sample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ItemAdapter(
        context: Context,
        private val itemList: List<Item>
) : RecyclerView.Adapter<ItemViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ItemViewHolder = ItemViewHolder.create(
            inflater,
            parent,
            false
    )

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(
            holder: ItemViewHolder,
            position: Int
    ) {
        holder.bind(itemList[position])
    }

}