package com.shirishkoirala.devchallenge.network.models

import com.google.gson.annotations.SerializedName

data class GenreDTO(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null
)