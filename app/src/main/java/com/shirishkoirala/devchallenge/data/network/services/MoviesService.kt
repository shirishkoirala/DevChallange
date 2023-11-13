package com.shirishkoirala.devchallenge.data.network.services

import android.util.Log
import com.shirishkoirala.devchallenge.data.network.apis.ApiService
import com.shirishkoirala.devchallenge.data.network.dtos.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.data.network.dtos.GetGenreListDto
import com.shirishkoirala.devchallenge.data.network.dtos.GetRatedMoviesResponse
import com.shirishkoirala.devchallenge.data.network.dtos.MovieDetailDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PopularMoviesDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostFavouriteMovieDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostRatingMovieDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostResponse
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
            Log.e("MoviesService", "searchMovies: ${it.message}")
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

    suspend fun postRating(movieId: Int, rating: Double): Flow<Result<PostResponse>> {
        val postRatingMovieDTO = PostRatingMovieDTO(
            value = rating
        )
        return flow {
            emit(Result.success(api.addRating(movieId, postRatingMovieDTO)))
        }.catch {
            Log.e("MoviesService", "postRating: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun getRatedMovies(accountId: Int): Flow<Result<GetRatedMoviesResponse>> {
        return flow {
            emit(Result.success(api.getRating(accountId)))
        }.catch {
            Log.e("MoviesService", "getRatedMovies: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun addFavourite(
        accountId: Int,
        movieId: Int,
        favourite: Boolean
    ): Flow<Result<PostResponse>> {
        val postRatingMovieDTO = PostFavouriteMovieDTO(mediaId = movieId, favorite = favourite)
        return flow {
            emit(Result.success(api.addFavourite(accountId, postRatingMovieDTO)))
        }.catch {
            Log.e("MoviesService", "postRating: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }
}