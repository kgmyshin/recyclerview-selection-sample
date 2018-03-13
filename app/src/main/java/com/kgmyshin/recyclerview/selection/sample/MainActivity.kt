package com.kgmyshin.recyclerview.selection.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.kgmyshin.recyclerview.selection.sample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var selectionTracker: SelectionTracker<Item>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val itemList = (1L..300L).map {
            Item(it, "title$it", "subtitle$it")
        }
        val adapter = ItemAdapter(this, itemList)
        binding.recyclerView.adapter = adapter
        (binding.recyclerView.layoutManager as? LinearLayoutManager)?.run {
            binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(
                            this@MainActivity,
                            orientation
                    )
            )
        }

        selectionTracker = SelectionTracker.Builder<Item>(
                "my-selection-id",
                binding.recyclerView,
                ItemKeyProvider(adapter),
                MyDetailsLookup(binding.recyclerView),
                StorageStrategy.createParcelableStorage(Item::class.java))
                .withOnItemActivatedListener { item, e ->
                    Log.e("aaaaa", item.toString())
                    return@withOnItemActivatedListener true
                }
                .build()

        adapter.selectionChecker = object : SelectionChecker {
            override fun isSelected(item: Item): Boolean =
                    selectionTracker?.isSelected(item) ?: false
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            selectionTracker?.onSaveInstanceState(outState)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            selectionTracker?.onRestoreInstanceState(savedInstanceState)
        }
    }
}
