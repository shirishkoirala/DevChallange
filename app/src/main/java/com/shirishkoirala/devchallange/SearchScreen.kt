package com.shirishkoirala.devchallange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shirishkoirala.devchallange.databinding.SearchScreenBinding

class SearchScreen : AppCompatActivity() {
    private lateinit var binding: SearchScreenBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchScreenBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
}