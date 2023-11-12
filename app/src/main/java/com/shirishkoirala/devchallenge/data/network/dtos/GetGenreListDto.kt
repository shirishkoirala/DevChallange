package com.shirishkoirala.devchallenge.data.network.dtos

import com.google.gson.annotations.SerializedName

data class GetGenreListDto(
    @SerializedName("genres") var genres: ArrayList<GenreDTO> = arrayListOf()
)