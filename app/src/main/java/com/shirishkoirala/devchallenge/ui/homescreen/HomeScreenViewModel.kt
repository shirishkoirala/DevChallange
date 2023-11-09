package com.shirishkoirala.devchallenge.ui.homescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shirishkoirala.devchallenge.repositories.MovieRepository

class HomeScreenViewModel(private val repository: MovieRepository) : ViewModel() {
    val loader = MutableLiveData<Boolean>()
    val popularList = liveData {
        loader.postValue(true)
        repository.getPopularMovieList().collect {
            loader.postValue(false)
            emit(it)
        }
    }
}