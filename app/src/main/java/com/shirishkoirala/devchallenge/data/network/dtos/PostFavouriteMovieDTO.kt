package com.shirishkoirala.devchallenge.data.network.dtos

import com.google.gson.annotations.SerializedName

data class PostFavouriteMovieDTO(
    @SerializedName("media_type")
    var mediaType: String? = "movie",
    @SerializedName("media_id")
    var mediaId: Int? = null,
    @SerializedName("favorite")
    var favorite: Boolean? = true
)