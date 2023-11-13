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
    val isFavourite = MutableLiveData<Boolean>()

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

    fun checkIfFavourite(movieId: Int) {
        loader.postValue(true)
        viewModelScope.launch {
            repository.checkIfFavourite(movieId).collect {
                if (it.isSuccess && it.getOrNull()!!) {
                    isFavourite.postValue(true)
                } else {
                    isFavourite.postValue(false)
                }
            }
        }
    }

    fun setFavourite(movieId: Int, boolean: Boolean) {
        loader.postValue(true)
        viewModelScope.launch {
            repository.setFavourite(movieId, boolean).collect { result ->
                if (result.isSuccess) {
                    isFavourite.value?.let {
                        isFavourite.postValue(!it)
                    }
                }
            }
        }
    }
}