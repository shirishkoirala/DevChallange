package com.shirishkoirala.devchallenge.di.modules

import com.shirishkoirala.devchallenge.data.network.mappers.FavouriteMoviesMapper
import com.shirishkoirala.devchallenge.data.network.mappers.GenreMapper
import com.shirishkoirala.devchallenge.data.network.mappers.MoviesMapper
import com.shirishkoirala.devchallenge.data.network.mappers.PopularMoviesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun popularMoviesMapper() = PopularMoviesMapper()

    @Provides
    fun moviesDetailMapper() = MoviesMapper()

    @Provides
    fun favouriteMoviesMapper() = FavouriteMoviesMapper()

    @Provides
    fun genreMapper() = GenreMapper()
}