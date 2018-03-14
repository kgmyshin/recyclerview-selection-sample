package com.kgmyshin.recyclerview.selection.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.recyclerview.selection.sample.databinding.ViewItemBinding

class BookViewHolder private constructor(
        private val binding: ViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): BookViewHolder = BookViewHolder(
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
            book: Book
    ) {
        binding.position = position
        binding.book = book
        binding.root.isActivated = isActivated
        binding.executePendingBindings()
    }

    fun getItemDetails(): BookDetails = BookDetails(
            position = binding.position,
            book = binding.book
    )

}