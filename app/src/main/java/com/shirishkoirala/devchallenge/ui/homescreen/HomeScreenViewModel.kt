package com.shirishkoirala.devchallenge.ui.homescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import com.shirishkoirala.devchallenge.models.Movie
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val repository: MovieRepository) : ViewModel() {
    val loader = MutableLiveData<Boolean>()
    val popularList = MutableLiveData<List<Movie>>()

    fun getPopularMovies() {
        loader.postValue(true)
        viewModelScope.launch {
            repository.getPopularMovieList().collect {
                loader.postValue(false)
                if (it.isSuccess) {
                    popularList.postValue(it.getOrNull())
                } else {

                }
            }
        }

    }
}