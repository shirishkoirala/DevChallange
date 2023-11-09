package com.shirishkoirala.devchallenge.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.repositories.MovieRepository
import javax.inject.Inject

class HomeScreenViewModelFactory @Inject constructor(
    private val repository: MovieRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(repository) as T
    }
}