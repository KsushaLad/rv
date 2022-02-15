package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CatsAdapter(list(), lists())
    }

    private fun list() : List<String>{
        val data = mutableListOf<String>()
        (0 until 20).map{
          data.add(Item(id = it, name = "name $it", description = "description$it").toString() )}
        return data
    }

    private fun lists() : MutableList<Item?>{
        val data = mutableListOf<Item?>()
        (0 until 20).map{
            Item(id = it, name = "name $it", description = "description$it").toString()}
        return data
    }

}