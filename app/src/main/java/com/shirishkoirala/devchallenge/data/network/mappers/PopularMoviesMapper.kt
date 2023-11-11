package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.data.network.models.PopularMoviesDTO
import javax.inject.Inject
import kotlin.math.roundToInt

class PopularMoviesMapper @Inject constructor() : Function1<PopularMoviesDTO, List<Movie>> {

    override fun invoke(p1: PopularMoviesDTO): List<Movie> {
        return p1.results.map { movieDTO ->
            var releasedYear: String? = null
            var popularity: String? = null

            movieDTO.releaseDate?.split('-')?.let {
                releasedYear = it[0]
            }

            movieDTO.voteAverage?.let {
                popularity = "${((it / 10) * 100).roundToInt()}"
            }
            Movie(
                id = movieDTO.id,
                title = movieDTO.title,
                year = releasedYear,
                userScore = popularity,
                posterPath = "https://image.tmdb.org/t/p/w500/${movieDTO.posterPath}"
            )
        }
    }
}