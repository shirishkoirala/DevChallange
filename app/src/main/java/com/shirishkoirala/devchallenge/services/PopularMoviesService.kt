package com.shirishkoirala.devchallenge.services

import android.util.Log
import com.shirishkoirala.devchallenge.network.apis.ApiService
import com.shirishkoirala.devchallenge.network.models.MovieDetailDTO
import com.shirishkoirala.devchallenge.network.models.PopularMoviesDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMoviesService @Inject constructor(
    private val api: ApiService
) {
    suspend fun fetchPopularMoviesService(): Flow<Result<PopularMoviesDTO>> {
        return flow {
            emit(Result.success(api.getTrendingMoviesOfTheDay()))
        }.catch {
            Log.e("PopularMoviesService", "fetchPopularMoviesService: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun fetchMovieDetail(movieId: Int): Flow<Result<MovieDetailDTO>> {
        return flow<Result<MovieDetailDTO>> {
            emit(Result.success(api.getMovieDetail(movieId)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }
}