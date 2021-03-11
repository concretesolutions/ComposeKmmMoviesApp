package br.com.concrete.composekmmmoviesapp.androidApp.data.dto

data class GenreDto(
    val genres: List<GenreItemDto>
)

data class GenreItemDto(
    val id: Int,
    val name: String
)
