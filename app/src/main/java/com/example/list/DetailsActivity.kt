package com.example.list

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.list.databinding.DetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailsBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // binding.textViewId.text = intent.getIntExtra("id", 0).toString()
        binding.textViewName.text = intent.getStringExtra("name")
        binding.textViewDescription.text = intent.getStringExtra("desc")
        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", sharedPreferences.toString())
        binding.textViewId.text = name
    }
}
