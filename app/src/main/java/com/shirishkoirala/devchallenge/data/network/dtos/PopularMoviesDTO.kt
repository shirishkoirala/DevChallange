package com.shirishkoirala.devchallenge.data.network.dtos

import com.google.gson.annotations.SerializedName

data class PopularMoviesDTO(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<MovieDTO> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null

)
