package com.shirishkoirala.devchallenge.data.network.interceptors

import android.content.Context
import com.shirishkoirala.devchallenge.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        requestBuilder.addHeader(
            "Authorization",
            "Bearer ${BuildConfig.API_KEY}"
        )

        return chain.proceed(requestBuilder.build())
    }
}