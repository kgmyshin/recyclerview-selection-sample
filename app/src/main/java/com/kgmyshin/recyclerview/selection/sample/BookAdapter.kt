package com.kgmyshin.recyclerview.selection.sample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class BookAdapter(
        context: Context,
        private val bookList: List<Book>
) : RecyclerView.Adapter<BookViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    var selectionChecker: SelectionChecker? = null

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): BookViewHolder = BookViewHolder.create(
            inflater,
            parent,
            false
    )

    fun getItem(position: Int): Book = bookList[position]

    fun getPosition(book: Book): Int = bookList.indexOf(book)

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(
            holder: BookViewHolder,
            position: Int
    ) {
        val item = bookList[position]
        holder.bind(
                selectionChecker?.isSelected(item) ?: false,
                position,
                bookList[position]
        )
    }

}