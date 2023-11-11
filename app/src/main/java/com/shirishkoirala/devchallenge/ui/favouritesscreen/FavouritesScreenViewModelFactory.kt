package com.shirishkoirala.devchallenge.ui.favouritesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import javax.inject.Inject

class FavouritesScreenViewModelFactory @Inject constructor(private val repository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavouritesScreenViewModel(repository) as T
    }
}