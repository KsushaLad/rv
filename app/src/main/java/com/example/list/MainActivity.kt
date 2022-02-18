package com.example.list

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ActivityMainBinding
import com.example.list.databinding.RecyclerviewItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding_item: RecyclerviewItemBinding

    @SuppressLint("NewApi", "CommitPrefEdits", "ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding_item = RecyclerviewItemBinding.inflate(layoutInflater)
        setContentView(view)
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapter()
        recyclerView.adapter = adapter
        val list = (0 until 20).map{
            Item(id = it, name = "name $it", description = "description $it")
        }
        adapter.submitList(list)
    }
}