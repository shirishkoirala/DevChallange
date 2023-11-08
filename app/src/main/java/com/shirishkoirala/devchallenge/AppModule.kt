package com.shirishkoirala.devchallenge

import com.shirishkoirala.devchallenge.network.apis.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient()

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @Provides
    fun playlistAPI(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun retrofit() = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}