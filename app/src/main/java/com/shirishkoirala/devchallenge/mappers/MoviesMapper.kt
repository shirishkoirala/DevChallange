package com.shirishkoirala.devchallenge.mappers

import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.network.models.PopularMoviesDTO
import javax.inject.Inject

class MoviesMapper @Inject constructor() : Function1<PopularMoviesDTO, List<Movie>> {
    override fun invoke(p1: PopularMoviesDTO): List<Movie> {
        return p1.results.map {
            var releasedYear: String? = null
            var popularity: String? = null

            it.releaseDate?.split('-')?.let {
                releasedYear = it[0]
            }

            it.voteAverage?.let {
                popularity = "${(it / 10) * 100}"
            }
            Movie(id = it.id, title = it.title, year = releasedYear, userScore = popularity)
        }
    }
}