package com.shirishkoirala.devchallenge.repositories

import com.shirishkoirala.devchallenge.mappers.MoviesMapper
import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.services.PopularMoviesService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PopularListRepository @Inject constructor(
    private val service: PopularMoviesService, private val mapper: MoviesMapper
) {
    suspend fun getPopularMovieList(): Flow<Result<List<Movie>>> =
        service.fetchPopularMoviesService().map {
            if (it.isSuccess) {
                Result.success(mapper(it.getOrNull()!!))
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }
        }
}