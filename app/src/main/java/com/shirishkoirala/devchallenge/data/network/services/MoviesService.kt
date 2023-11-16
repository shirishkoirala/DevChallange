package com.shirishkoirala.devchallenge.data.network.services

import android.util.Log
import com.shirishkoirala.devchallenge.data.network.apis.TmdbApi
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
    private val tmdbApi: TmdbApi
) {
    suspend fun fetchPopularMoviesService(): Flow<Result<PopularMoviesDTO>> {
        return flow {
            emit(Result.success(tmdbApi.getTrendingMoviesOfTheDay()))
        }.catch {
            Log.e("PopularMoviesService", "fetchPopularMoviesService: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun fetchMovieDetail(movieId: Int): Flow<Result<MovieDetailDTO>> {
        return flow {
            emit(Result.success(tmdbApi.getMovieDetail(movieId)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun fetchFavouriteMovies(accountId: Int): Flow<Result<FavouriteMoviesDTO>> {
        return flow {
            emit(Result.success(tmdbApi.getFavouritesMovies(accountId)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun searchMovies(query: String): Flow<Result<PopularMoviesDTO>> {
        return flow {
            emit(Result.success(tmdbApi.search(query)))
        }.catch {
            Log.e("MoviesService", "searchMovies: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun getMovieGenre(): Flow<Result<GetGenreListDto>> {
        return flow {
            emit(Result.success(tmdbApi.getAllGenre()))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun postRating(movieId: Int, rating: Double): Flow<Result<PostResponse>> {
        val postRatingMovieDTO = PostRatingMovieDTO(
            value = rating
        )
        return flow {
            emit(Result.success(tmdbApi.addRating(movieId, postRatingMovieDTO)))
        }.catch {
            Log.e("MoviesService", "postRating: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }

    suspend fun getRatedMovies(accountId: Int): Flow<Result<GetRatedMoviesResponse>> {
        return flow {
            emit(Result.success(tmdbApi.getRating(accountId)))
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
            emit(Result.success(tmdbApi.addFavourite(accountId, postRatingMovieDTO)))
        }.catch {
            Log.e("MoviesService", "postRating: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }
    }
}