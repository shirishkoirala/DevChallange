package com.shirishkoirala.devchallenge.services

import com.shirishkoirala.devchallenge.network.apis.ApiService
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
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }
}