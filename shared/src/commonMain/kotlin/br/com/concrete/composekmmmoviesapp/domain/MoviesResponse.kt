package br.com.concrete.composekmmmoviesapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val page: Int,
    val results: List<Movie>
)

@Serializable
data class Movie(
    @SerialName("id")
    val id: Int,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("genre_ids")
    val genres: List<Int>,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("overview")
    val overview:String
)