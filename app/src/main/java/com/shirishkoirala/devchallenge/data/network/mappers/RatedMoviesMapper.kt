package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.data.local.daos.GenreDao
import com.shirishkoirala.devchallenge.data.local.entities.RatedMoviesEntity
import com.shirishkoirala.devchallenge.data.network.dtos.GetRatedMoviesResponse
import com.shirishkoirala.devchallenge.models.Movie
import kotlin.math.roundToInt

object RatedMoviesMapper {
    suspend fun mapRatedMoviesResponseToRatedMovies(
        getRatedMoviesResponse: GetRatedMoviesResponse,
        genreDao: GenreDao
    ): List<Movie> {
        return getRatedMoviesResponse.results.map {
            var releasedYear: String? = null
            var popularity: String? = null

            it.releaseDate?.split('-')?.let {
                releasedYear = it[0]
            }

            it.voteAverage?.let {
                popularity = "${((it / 10) * 100).roundToInt()}"
            }
            Movie(
                id = it.id,
                title = it.title,
                year = releasedYear,
                userScore = popularity,
                posterPath = "https://image.tmdb.org/t/p/w500/${it.posterPath}",
                backdropPath = "https://image.tmdb.org/t/p/w500/${it.backdropPath}",
                overview = it.overview,
                genres = GenreMapper.mapGenreEntityToGenre(genreDao.getGenres(it.genreIds)),
            )
        }
    }

    fun mapRatedMoviesResponseToRatedMoviesEntity(getRatedMoviesResponse: GetRatedMoviesResponse): List<RatedMoviesEntity> {
        return getRatedMoviesResponse.results.map {
            RatedMoviesEntity(
                movieId = it.id
            )
        }
    }
}