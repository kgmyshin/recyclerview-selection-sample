package com.kgmyshin.recyclerview.selection.sample

import androidx.recyclerview.selection.ItemDetailsLookup

data class BookDetails(
        private val position: Int,
        private val book: Book?
) : ItemDetailsLookup.ItemDetails<Book>() {

    override fun getPosition(): Int = position

    override fun getSelectionKey(): Book? = book
}