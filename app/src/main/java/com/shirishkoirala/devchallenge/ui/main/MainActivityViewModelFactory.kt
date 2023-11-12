package com.shirishkoirala.devchallenge.ui.main;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository;
import javax.inject.Inject


class MainActivityViewModelFactory @Inject constructor(
    private val repository: MovieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}
