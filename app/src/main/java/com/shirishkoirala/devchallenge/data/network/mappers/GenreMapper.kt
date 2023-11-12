package com.shirishkoirala.devchallenge.data.network.mappers

import com.shirishkoirala.devchallenge.data.local.entities.GenreEntity
import com.shirishkoirala.devchallenge.data.network.dtos.GetGenreListDto
import com.shirishkoirala.devchallenge.models.Genre

object GenreMapper {

    fun mapToGenreEntity(getGenreListDto: GetGenreListDto): List<GenreEntity> {
        return getGenreListDto.genres.map {
            GenreEntity(
                genreId = it.id!!,
                genreName = it.name!!
            )
        }
    }

    fun mapToGenre(getGenreListDto: GetGenreListDto): List<Genre> {
        return getGenreListDto.genres.map {
            Genre(
                id = it.id,
                name = it.name
            )
        }
    }

    fun mapGenreEntityToGenre(genreEntities: List<GenreEntity>): List<Genre> {
        return genreEntities.map {
            Genre(
                id = it.genreId,
                name = it.genreName
            )
        }
    }
}