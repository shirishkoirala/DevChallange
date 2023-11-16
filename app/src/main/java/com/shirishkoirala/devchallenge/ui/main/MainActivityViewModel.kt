package com.shirishkoirala.devchallenge.ui.main;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

public class MainActivityViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    val loader = MutableLiveData<Boolean>()

    fun getAllGenre() {
        loader.postValue(true)
        viewModelScope.launch {
            repository.fetchAllGenres().collect {
                loader.postValue(false)
            }
        }
    }

    fun getFavourites() {
        loader.postValue(true)
        viewModelScope.launch {
            repository.getFavouritesMovieList(20678273).collect {
                loader.postValue(false)
            }
        }
    }

    fun getRatedMovies() {
        loader.postValue(true)
        viewModelScope.launch {
            repository.getRatedMovies(20678273).collect {
                loader.postValue(false)
            }
        }
    }
}
