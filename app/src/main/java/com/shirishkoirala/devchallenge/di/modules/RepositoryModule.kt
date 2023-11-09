package com.shirishkoirala.devchallenge.di.modules

import com.shirishkoirala.devchallenge.mappers.MoviesMapper
import com.shirishkoirala.devchallenge.mappers.PopularMoviesMapper
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
}