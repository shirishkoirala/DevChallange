package com.shirishkoirala.devchallenge.data.network.models

import com.google.gson.annotations.SerializedName

data class PostRatingMovieDTO(
    @SerializedName("value") var value: Double? = null
)
