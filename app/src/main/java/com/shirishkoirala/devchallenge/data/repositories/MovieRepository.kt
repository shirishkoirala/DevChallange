package com.shirishkoirala.devchallenge.data.repositories

import android.util.Log
import com.shirishkoirala.devchallenge.data.local.MovieDatabase
import com.shirishkoirala.devchallenge.data.network.mappers.FavouriteMoviesMapper
import com.shirishkoirala.devchallenge.data.network.mappers.GenreMapper
import com.shirishkoirala.devchallenge.data.network.mappers.MovieMapper
import com.shirishkoirala.devchallenge.data.network.mappers.PopularMoviesMapper
import com.shirishkoirala.devchallenge.data.network.mappers.RatedMoviesMapper
import com.shirishkoirala.devchallenge.data.network.services.MoviesService
import com.shirishkoirala.devchallenge.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val service: MoviesService,
    private val movieDatabase: MovieDatabase,
) {


    suspend fun getPopularMovieList(): Flow<Result<List<Movie>>> =
        service.fetchPopularMoviesService().map {
            if (it.isSuccess) {
                Result.success(
                    PopularMoviesMapper.mapPopularMoviesDtoToMovie(
                        it.getOrNull()!!, movieDatabase.getGenreDao()
                    )
                )
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }
        }

    suspend fun getMovieDetail(movieId: Int): Flow<Result<Movie>> =
        service.fetchMovieDetail(movieId).map {
            if (it.isSuccess) {
                Result.success(MovieMapper.map(it.getOrNull()!!))
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }
        }

    suspend fun getFavouritesMovieList(accountId: Int): Flow<Result<List<Movie>>> =
        service.fetchFavouriteMovies(accountId).map {
            if (it.isSuccess) {
                movieDatabase.getFavouriteDao()
                    .insertAll(FavouriteMoviesMapper.mapFavouriteMoviesDtoToFavouriteEntity(it.getOrNull()!!))
                Result.success(FavouriteMoviesMapper.map(it.getOrNull()!!))
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }
        }

    suspend fun fetchAllGenres(): Flow<Result<Boolean>> {
        return flow {
            service.getMovieGenre().collect {
                if (it.isSuccess) {
                    movieDatabase.getGenreDao()
                        .insertAll(GenreMapper.mapToGenreEntity(it.getOrNull()!!))
                    emit(Result.success(true))
                } else {
                    emit(Result.failure(it.exceptionOrNull()!!))
                }
            }
        }
    }

    suspend fun search(query: String): Flow<Result<List<Movie>>> =
        service.searchMovies(query).map {
            if (it.isSuccess) {
                Result.success(
                    PopularMoviesMapper.mapPopularMoviesDtoToMovie(
                        it.getOrNull()!!,
                        movieDatabase.getGenreDao()
                    )
                )
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }

        }

    suspend fun postRating(movieId: Int, rating: Double): Flow<Result<Boolean>> =
        service.postRating(movieId, rating).map {
            if (it.isSuccess) {
                Result.success(true)
            } else {
                Result.failure(RuntimeException(it.exceptionOrNull()))
            }
        }

    suspend fun getRatedMovies(accountId: Int): Flow<Result<List<Movie>>> =
        service.getRatedMovies(accountId).map {
            if (it.isSuccess) {
                movieDatabase.getRatedMoviesDao().insertAll(
                    RatedMoviesMapper.mapRatedMoviesResponseToRatedMoviesEntity(it.getOrNull()!!)
                )
                Result.success(
                    RatedMoviesMapper.mapRatedMoviesResponseToRatedMovies(
                        it.getOrNull()!!,
                        movieDatabase.getGenreDao()
                    )
                )
            } else {
                Result.failure(RuntimeException(it.exceptionOrNull()))
            }
        }

    suspend fun addFavourites(accountId: Int, movieId: Int): Flow<Result<Boolean>> =
        service.addFavourite(accountId, movieId, true).map {
            if (it.isSuccess) {
                Result.success(true)
            } else {
                Result.failure(RuntimeException(it.exceptionOrNull()))
            }
        }

    suspend fun checkIfFavourite(movieId: Int): Flow<Result<Boolean>> {
        return flow {
            movieDatabase.getFavouriteDao().getFavourite(movieId).collect {
                it?.let {
                    emit(Result.success(true))
                    Log.d("MovieRepository", "checkIfFavourite: true")
                } ?: run {
                    emit(Result.success(false))
                    Log.d("MovieRepository", "checkIfFavourite: false")
                }
            }
        }.catch {
            Log.e("MovieRepository", "checkIfFavourite: ${it.message}")
            emit(Result.failure(RuntimeException("Something went wrong!")))
        }

    }

    suspend fun setFavourite(movieId: Int, favourite: Boolean) =
        service.addFavourite(20678273, movieId, favourite).map {
            if (it.isSuccess) {
                if (!favourite) {
                    movieDatabase.getFavouriteDao().delete(movieId)
                }
                Result.success(true)
            } else {
                Result.failure(RuntimeException(it.exceptionOrNull()))
            }
        }

}

