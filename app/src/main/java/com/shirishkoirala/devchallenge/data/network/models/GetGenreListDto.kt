package com.shirishkoirala.devchallenge.data.network.models

import com.google.gson.annotations.SerializedName

data class GetGenreListDto(
    @SerializedName("genres") var genres: ArrayList<GenreDTO> = arrayListOf()
)