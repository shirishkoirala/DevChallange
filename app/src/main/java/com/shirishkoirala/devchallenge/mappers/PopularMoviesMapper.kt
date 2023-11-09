package com.shirishkoirala.devchallenge.mappers

import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.network.models.PopularMoviesDTO
import javax.inject.Inject
import kotlin.math.roundToInt

class PopularMoviesMapper @Inject constructor() : Function1<PopularMoviesDTO, List<Movie>> {
    override fun invoke(p1: PopularMoviesDTO): List<Movie> {
        return p1.results.map {
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