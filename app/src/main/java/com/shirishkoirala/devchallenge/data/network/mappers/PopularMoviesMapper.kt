package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.data.local.daos.GenreDao
import com.shirishkoirala.devchallenge.data.network.dtos.PopularMoviesDTO
import com.shirishkoirala.devchallenge.models.Movie

object PopularMoviesMapper {

    suspend fun mapPopularMoviesDtoToMovie(
        popularMoviesDTO: PopularMoviesDTO,
        genreDao: GenreDao
    ): List<Movie> {
        return popularMoviesDTO.results.map { movieDTO ->
            MovieMapper.mapMovieDtoToMovie(movieDTO, genreDao)
        }

    }
}