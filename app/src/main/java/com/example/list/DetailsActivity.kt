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
        binding.textView.text = intent.getStringExtra("all")

    }
}
