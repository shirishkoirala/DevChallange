package com.shirishkoirala.devchallenge.data.repositories

import com.shirishkoirala.devchallenge.data.local.MovieDatabase
import com.shirishkoirala.devchallenge.data.network.mappers.FavouriteMoviesMapper
import com.shirishkoirala.devchallenge.data.network.mappers.GenreMapper
import com.shirishkoirala.devchallenge.data.network.mappers.MovieMapper
import com.shirishkoirala.devchallenge.data.network.mappers.PopularMoviesMapper
import com.shirishkoirala.devchallenge.data.network.services.MoviesService
import com.shirishkoirala.devchallenge.models.Movie
import kotlinx.coroutines.flow.Flow
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
}

