package com.shirishkoirala.devchallenge.ui.detailscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import com.shirishkoirala.devchallenge.models.Movie
import kotlinx.coroutines.launch

class DetailScreenViewModel(private val repository: MovieRepository) : ViewModel() {
    val loader = MutableLiveData<Boolean>()
    val movieDetail = MutableLiveData<Movie>()

    fun getMovieDetail(movieId: Int) {
        loader.postValue(true)
        viewModelScope.launch {
            repository.getMovieDetail(movieId).collect {
                if (it.isSuccess) {
                    movieDetail.postValue(it.getOrNull())
                    loader.postValue(false)
                } else {
                    it.exceptionOrNull()
                }
            }
        }
    }
}