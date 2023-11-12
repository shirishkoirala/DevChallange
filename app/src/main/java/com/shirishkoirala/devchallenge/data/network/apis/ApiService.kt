package com.shirishkoirala.devchallenge.data.network.apis

import com.shirishkoirala.devchallenge.data.network.models.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.data.network.models.GetGenreListDto
import com.shirishkoirala.devchallenge.data.network.models.MovieDetailDTO
import com.shirishkoirala.devchallenge.data.network.models.PopularMoviesDTO
import com.shirishkoirala.devchallenge.data.network.models.PostFavouriteMovieDTO
import com.shirishkoirala.devchallenge.data.network.models.PostRatingMovieDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMoviesOfTheDay(): PopularMoviesDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailDTO

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavouritesMovies(@Path("account_id") accountId: Int): FavouriteMoviesDTO

    @GET("search/movie")
    suspend fun search(query: String): PopularMoviesDTO

    @GET("genre/movie/list")
    suspend fun getAllGenre(): GetGenreListDto

    @POST("account/{account_id}/favorite")
    suspend fun addFavourite(
        @Path("account_id") accountId: Int,
        @Body postFavouriteMovieDTO: PostFavouriteMovieDTO
    )

    @POST("movie/{movie_id}/rating")
    suspend fun addRating(
        @Path("movie_id") movieId: Int,
        @Body postRatingMovieDTO: PostRatingMovieDTO
    )

}