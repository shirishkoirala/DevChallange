package com.shirishkoirala.devchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var navigator: Navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        navigator.activity = this

        navigator.showPopularMovies()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.activity = null
    }
}