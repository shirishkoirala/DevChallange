package com.shirishkoirala.devchallenge.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shirishkoirala.devchallenge.repositories.PopularListRepository
import javax.inject.Inject

class HomeScreenViewModelFactory @Inject constructor(
    private val repository: PopularListRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(repository) as T
    }
}