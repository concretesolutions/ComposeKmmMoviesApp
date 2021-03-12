package br.com.concrete.composekmmmoviesapp.androidApp.data.model

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val overview: String,
    val releaseYear: Int,
    val genres: List<Genre>
)