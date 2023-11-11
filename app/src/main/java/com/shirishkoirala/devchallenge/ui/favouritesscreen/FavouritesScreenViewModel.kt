package com.shirishkoirala.devchallenge.ui.favouritesscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.data.repositories.MovieRepository
import kotlinx.coroutines.launch

class FavouritesScreenViewModel(private val repository: MovieRepository) : ViewModel() {
    val loader = MutableLiveData<Boolean>()
    val favouriteMoviesList = MutableLiveData<List<Movie>>()

    fun getFavouriteMovies(accountId: Int) {
        loader.postValue(true)
        viewModelScope.launch {
            repository.getFavouritesMovieList(accountId).collect {
                if (it.isSuccess) {
                    favouriteMoviesList.postValue(it.getOrNull())
                    loader.postValue(false)
                } else {
                    it.exceptionOrNull()
                }
            }
        }
    }
}