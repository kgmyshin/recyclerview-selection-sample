package com.kgmyshin.recyclerview.selection.sample

import androidx.recyclerview.selection.ItemDetailsLookup

data class BookIdDetails(
        private val position: Int,
        private val id: Long?
) : ItemDetailsLookup.ItemDetails<Long>() {

    override fun getPosition(): Int = position

    override fun getSelectionKey(): Long? = id
}