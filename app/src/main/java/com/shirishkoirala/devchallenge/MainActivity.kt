package com.shirishkoirala.devchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator = Navigator(this)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        navigator.activity = this
        navigator.showPopularMovies()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}