package com.shirishkoirala.devchallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.coordinators.Navigator
import com.shirishkoirala.devchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navigator: Navigator
    private lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator = Navigator(this)
        binding = ActivityMainBinding.inflate(layoutInflater);
        viewModel =
            ViewModelProvider(this, mainActivityViewModelFactory)[MainActivityViewModel::class.java]
        viewModel.getAllGenre()
        viewModel.getFavourites()
        viewModel.getRatedMovies()
        setContentView(binding.root)
        navigator.activity = this
        navigator.showPopularMovies()
    }
}