package com.shirishkoirala.devchallenge.models

data class Movie(
    var id: Int? = null,
    var title: String? = null,
    var year: String? = null,
    var userScore: String? = null,
    var genres: List<Genre>? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null,
    var overview: String? = null,
)
