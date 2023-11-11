package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.data.network.models.FavouriteMoviesDTO
import kotlin.math.roundToInt

class FavouriteMoviesMapper : Function1<FavouriteMoviesDTO, List<Movie>> {
    override fun invoke(favouriteMoviesDTO: FavouriteMoviesDTO): List<Movie> {
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