package com.shirishkoirala.devchallenge.homescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.repositories.PopularListRepository
import kotlinx.coroutines.flow.onEach

class HomeScreenViewModel(private val repository: PopularListRepository) : ViewModel() {
    val loader = MutableLiveData<Boolean>()
    val popularList = liveData<Result<List<Movie>>> {
        loader.postValue(true)
        emitSource(repository.getPopularMovieList().onEach {

        }.asLiveData())
    }
}