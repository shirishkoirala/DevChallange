package com.shirishkoirala.devchallenge.data.network.dtos

import com.google.gson.annotations.SerializedName

data class GetRatedMoviesResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<RatedMovieDto> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
)