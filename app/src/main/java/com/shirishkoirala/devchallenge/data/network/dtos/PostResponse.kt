package com.shirishkoirala.devchallenge.data.network.dtos

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("status_code") var statusCode: Int? = null,
    @SerializedName("status_message") var statusMessage: String? = null
)
