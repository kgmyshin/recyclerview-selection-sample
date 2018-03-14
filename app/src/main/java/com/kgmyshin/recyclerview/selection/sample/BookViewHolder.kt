package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.recyclerview.selection.sample.databinding.ViewBookBinding

class BookViewHolder private constructor(
        private val binding: ViewBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): BookViewHolder = BookViewHolder(
                ViewBookBinding.inflate(
                        inflater,
                        parent,
                        attachToRoot
                )
        )
    }

    fun bind(
            isActivated: Boolean,
            position: Int,
            book: Book
    ) {
        binding.position = position
        binding.book = book
        binding.root.isActivated = isActivated
        binding.executePendingBindings()
    }

    fun getItemIdDetails(): BookIdDetails = BookIdDetails(
            position = binding.position,
            id = binding.book?.id
    )

}