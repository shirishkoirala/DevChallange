package com.shirishkoirala.devchallenge.data.network.interceptors

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        requestBuilder.addHeader(
            "Authorization",
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZjgyYTdmMDk5MjQ1MzJkNWYxOGU4NTE1ZmVlYmFjZCIsInN1YiI6IjY1NGFkYmYyMjg2NmZhMDExYmQxMTc2MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3Ow8pqD_WQEXYR0KCO1JQ_te4Ti3wMU3kCXgEOijvRY"
        )

        return chain.proceed(requestBuilder.build())
    }
}