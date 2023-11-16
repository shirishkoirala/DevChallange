package com.shirishkoirala.devchallenge.data.network.apis

import com.shirishkoirala.devchallenge.data.network.dtos.FavouriteMoviesDTO
import com.shirishkoirala.devchallenge.data.network.dtos.GetGenreListDto
import com.shirishkoirala.devchallenge.data.network.dtos.GetRatedMoviesResponse
import com.shirishkoirala.devchallenge.data.network.dtos.MovieDetailDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PopularMoviesDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostFavouriteMovieDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostRatingMovieDTO
import com.shirishkoirala.devchallenge.data.network.dtos.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {
    @GET("trending/movie/day")
    suspend fun getTrendingMoviesOfTheDay(): PopularMoviesDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailDTO

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavouritesMovies(@Path("account_id") accountId: Int): FavouriteMoviesDTO

    @GET("search/movie")
    suspend fun search(@Query("query", encoded = true) query: String): PopularMoviesDTO

    @GET("genre/movie/list")
    suspend fun getAllGenre(): GetGenreListDto

    @POST("account/{account_id}/favorite")
    suspend fun addFavourite(
        @Path("account_id") accountId: Int,
        @Body postFavouriteMovieDTO: PostFavouriteMovieDTO
    ): PostResponse

    @POST("movie/{movie_id}/rating")
    suspend fun addRating(
        @Path("movie_id") movieId: Int,
        @Body postRatingMovieDTO: PostRatingMovieDTO
    ): PostResponse

    @GET("account/{account_id}/rated/movies")
    suspend fun getRating(@Path("account_id") accountId: Int): GetRatedMoviesResponse
}