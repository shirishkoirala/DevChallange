package com.shirishkoirala.devchallenge.network.apis

import com.shirishkoirala.devchallenge.network.models.PopularMoviesDTO
import retrofit2.http.GET

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMoviesOfTheDay(): PopularMoviesDTO
}