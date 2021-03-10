package br.com.concrete.composekmmmoviesapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movies(
    val page: Int,
    val results: List<Movie>
)

@Serializable
data class Movie(
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("genre_ids")
    val genres: List<Int>,
    @SerialName("release_date")
    val releaseDate: String
)