package com.shirishkoirala.devchallenge.ui.ratingdialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import kotlinx.coroutines.launch

class RatingDialogViewModel(private val repository: MovieRepository) : ViewModel() {
    val dismiss = MutableLiveData<Result<Boolean>>()
    fun postRating(movieId: Int, intScore: Double) {
        viewModelScope.launch {
            repository.postRating(movieId, intScore).collect {
                dismiss.postValue(it)
            }
        }
    }
}