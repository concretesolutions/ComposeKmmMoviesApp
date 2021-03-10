package br.com.concrete.composekmmmoviesapp.androidApp.data.dto

import com.google.gson.annotations.SerializedName

data class MoviePage(
    val page: Int,
    @SerializedName("results") val movieItems: List<MovieItem>
)

class MovieItem(
    @SerializedName("backdrop_path") val backdropPath: String,
    val title: String,
    @SerializedName("release_date") val release_date: String,
)
