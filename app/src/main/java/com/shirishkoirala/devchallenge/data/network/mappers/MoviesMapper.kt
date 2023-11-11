package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.models.Movie
import com.shirishkoirala.devchallenge.data.network.models.MovieDetailDTO
import kotlin.math.roundToInt

class MoviesMapper : Function1<MovieDetailDTO, Movie> {
    override fun invoke(detailMovieDto: MovieDetailDTO): Movie {

        var releasedYear: String? = null
        var popularity: String? = null

        detailMovieDto.releaseDate?.split('-')?.let {
            releasedYear = it[0]
        }

        detailMovieDto.voteAverage?.let {
            popularity = "${((it / 10) * 100).roundToInt()}"
        }
        return Movie(
            id = detailMovieDto.id,
            title = detailMovieDto.title,
            year = releasedYear,
            userScore = popularity,
            posterPath = "https://image.tmdb.org/t/p/w500/${detailMovieDto.posterPath}",
            backdropPath = "https://image.tmdb.org/t/p/w500/${detailMovieDto.backdropPath}",
            overview = detailMovieDto.overview,
        )
    }
}