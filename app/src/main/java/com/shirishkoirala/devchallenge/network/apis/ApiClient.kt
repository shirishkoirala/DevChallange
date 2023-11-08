package com.shirishkoirala.devchallenge.network.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiClient {
    private val base_url = "https://api.themoviedb.org/3/"

     fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(okHttpClient)
            .build()
    }

}