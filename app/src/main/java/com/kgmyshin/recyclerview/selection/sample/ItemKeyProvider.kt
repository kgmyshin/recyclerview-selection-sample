package com.kgmyshin.recyclerview.selection.sample

import androidx.recyclerview.selection.ItemKeyProvider

class ItemKeyProvider(
        private val itemAdapter: ItemAdapter
) : ItemKeyProvider<Item>(ItemKeyProvider.SCOPE_CACHED) {
    override fun getKey(position: Int): Item? = itemAdapter.getItem(position)

    override fun getPosition(key: Item): Int = itemAdapter.getPosition(key)
}