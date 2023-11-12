package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.data.network.dtos.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.models.Movie
import kotlin.math.roundToInt

object FavouriteMoviesMapper {
    fun map(favouriteMoviesDTO: FavouriteMoviesDTO): List<Movie> {
        return favouriteMoviesDTO.results.map {
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
                posterPath = "https://image.tmdb.org/t/p/w500/${it.posterPath}"
            )
        }
    }
}