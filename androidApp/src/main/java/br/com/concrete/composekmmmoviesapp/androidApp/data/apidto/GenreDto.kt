package br.com.concrete.composekmmmoviesapp.androidApp.data.apidto

data class GenreDto(
    val genres: List<GenreItemDto>
)

data class GenreItemDto(
    val id: Int,
    val name: String
)
