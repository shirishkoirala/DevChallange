package com.shirishkoirala.devchallenge.di.modules

import android.content.Context
import com.shirishkoirala.devchallenge.data.network.apis.TmdbApi
import com.shirishkoirala.devchallenge.data.network.interceptors.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Singleton
    @Provides
    fun okHttpClient(authInterceptor: AuthInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun apiService(retrofit: Retrofit): TmdbApi = retrofit.create(TmdbApi::class.java)

    @Singleton
    @Provides
    fun interceptor(@ApplicationContext context: Context): AuthInterceptor = AuthInterceptor(context)

    @Singleton
    @Provides
    fun retrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}