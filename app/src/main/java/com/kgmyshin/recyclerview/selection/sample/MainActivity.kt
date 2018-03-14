package com.kgmyshin.recyclerview.selection.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import com.kgmyshin.recyclerview.selection.sample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var selectionTracker: SelectionTracker<Long>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val itemList = (1L..300L).map {
            Book(it, "title$it", "subtitle$it")
        }
        val adapter = BookAdapter(this, itemList)
        binding.recyclerView.adapter = adapter
        (binding.recyclerView.layoutManager as? LinearLayoutManager)?.run {
            binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(
                            this@MainActivity,
                            orientation
                    )
            )
        }

        selectionTracker = SelectionTracker.Builder<Long>(
                "my-selection-id",
                binding.recyclerView,
                StableIdKeyProvider(binding.recyclerView),
                BookIdDetailsLookup(binding.recyclerView),
                StorageStrategy.createLongStorage())
                .withOnItemActivatedListener { item, e ->
                    Log.e("MainActivity", item.toString())
                    return@withOnItemActivatedListener true
                }
                .build()

        adapter.selectionChecker = object : SelectionChecker {
            override fun isSelected(id: Long): Boolean =
                    selectionTracker?.isSelected(id) ?: false
        }

        if (savedInstanceState != null) {
            selectionTracker?.onRestoreInstanceState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            selectionTracker?.onSaveInstanceState(outState)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
                R.menu.menus_main,
                menu
        )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val itemId = item?.itemId ?: return super.onOptionsItemSelected(item)

        when (itemId) {
            R.id.menu_show -> {
                val selectionText = selectionTracker?.let {
                    it.selection.map {
                        val target = it as Long // bug: selection dont have type parameter
                        target
                    }.joinToString("\n")
                }
                Toast.makeText(
                        this,
                        selectionText,
                        Toast.LENGTH_SHORT
                ).show()
            }
            R.id.menu_clear -> {
                selectionTracker?.clearSelection()
            }
        }
        return true
    }
}
