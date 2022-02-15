package com.example.list

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.list.databinding.DetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val ss: String = intent.getStringExtra("id").toString()
        val s1: String = intent.getStringExtra("name").toString()
        val s2: String = intent.getStringExtra("description").toString()
        binding.textView.text = ss
        binding.textView3.text = s1
        binding.textView2.text = s2
    }
}
