package br.com.concrete.composekmmmoviesapp.domain

data class FavoriteMovie(
    val id: Long,
    val posterPath: String,
    val originalTitle: String,
    val genres: String,
    val releaseYear: Int,
    val overview: String?
)