package com.shirishkoirala.devchallenge.services

import android.util.Log
import com.shirishkoirala.devchallenge.data.network.apis.ApiService
import com.shirishkoirala.devchallenge.data.network.models.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.data.network.models.GetGenreListDto
import com.shirishkoirala.devchallenge.data.network.models.MovieDetailDTO
import com.shirishkoirala.devchallenge.data.network.models.PopularMoviesDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesService @Inject constructor(
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

    suspend fun fetchFavouriteMovies(accountId: Int): Flow<Result<FavouriteMoviesDTO>> {
        return flow<Result<FavouriteMoviesDTO>> {
            emit(Result.success(api.getFavouritesMovies(accountId)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun searchMovies(query: String): Flow<Result<PopularMoviesDTO>> {
        return flow<Result<PopularMoviesDTO>> {
            emit(Result.success(api.search(query)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun getMovieGenre(): Flow<Result<GetGenreListDto>> {
        return flow<Result<GetGenreListDto>> {
            emit(Result.success(api.getAllGenre()))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }
}