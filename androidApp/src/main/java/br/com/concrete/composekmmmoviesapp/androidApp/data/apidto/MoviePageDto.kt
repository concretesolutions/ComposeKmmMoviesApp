package br.com.concrete.composekmmmoviesapp.androidApp.data.apidto

import com.google.gson.annotations.SerializedName

data class MoviePageDto(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movieItems: List<MovieItemDto>
)

class MovieItemDto(
    @SerializedName("id") val id: Int,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("title") val title: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String,
)
