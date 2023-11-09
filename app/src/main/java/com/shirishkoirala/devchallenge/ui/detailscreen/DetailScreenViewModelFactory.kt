package com.shirishkoirala.devchallenge.ui.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.repositories.MovieRepository
import javax.inject.Inject

class DetailScreenViewModelFactory @Inject constructor(private val repository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailScreenViewModel(repository) as T
    }
}