package com.shirishkoirala.devchallenge.network.apis

import com.shirishkoirala.devchallenge.network.models.MovieDTO
import com.shirishkoirala.devchallenge.network.models.MovieDetailDTO
import com.shirishkoirala.devchallenge.network.models.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMoviesOfTheDay(): PopularMoviesDTO
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailDTO
}