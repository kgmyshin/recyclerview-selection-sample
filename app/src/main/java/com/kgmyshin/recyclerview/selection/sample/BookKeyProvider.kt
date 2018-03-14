package com.kgmyshin.recyclerview.selection.sample

import androidx.recyclerview.selection.ItemKeyProvider

class BookKeyProvider(
        private val bookAdapter: BookAdapter
) : ItemKeyProvider<Book>(ItemKeyProvider.SCOPE_CACHED) {
    override fun getKey(position: Int): Book? = bookAdapter.getItem(position)

    override fun getPosition(key: Book): Int = bookAdapter.getPosition(key)
}