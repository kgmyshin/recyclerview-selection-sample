package com.kgmyshin.recyclerview.selection.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.kgmyshin.recyclerview.selection.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

    }
}
