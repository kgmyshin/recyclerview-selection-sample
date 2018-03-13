package com.kgmyshin.recyclerview.selection.sample

import androidx.recyclerview.selection.ItemDetailsLookup

data class ItemDetails(
        private val position: Int,
        private val item: Item?
) : ItemDetailsLookup.ItemDetails<Item>() {

    override fun getPosition(): Int = position

    override fun getSelectionKey(): Item? = item
}