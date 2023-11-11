package com.shirishkoirala.devchallenge.data.network.apis

import com.shirishkoirala.devchallenge.data.network.models.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.data.network.models.MovieDetailDTO
import com.shirishkoirala.devchallenge.data.network.models.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMoviesOfTheDay(): PopularMoviesDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailDTO

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavouritesMovies(@Path("account_id") accountId: Int): FavouriteMoviesDTO
}