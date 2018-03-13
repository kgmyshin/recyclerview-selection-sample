package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.recyclerview.selection.sample.databinding.ViewItemBinding

class ItemViewHolder private constructor(
        private val binding: ViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): ItemViewHolder = ItemViewHolder(
                ViewItemBinding.inflate(
                        inflater,
                        parent,
                        attachToRoot
                )
        )
    }

    fun bind(
            isActivated: Boolean,
            position: Int,
            item: Item
    ) {
        binding.position = position
        binding.item = item
        binding.root.isActivated = isActivated
        binding.executePendingBindings()
    }

    fun getItemDetails(): ItemDetails = ItemDetails(
            position = binding.position,
            item = binding.item
    )

}