package com.shirishkoirala.devchallenge.ui.ratingdialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import javax.inject.Inject

class RatingDialogViewModelFactory @Inject constructor(private val repository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RatingDialogViewModel(repository) as T
    }
}