package br.com.concrete.composekmmmoviesapp.domain

import kotlinx.serialization.Serializable

@Serializable
data class GenresResponse(
    val genres: List<GenreResponse>
)

@Serializable
data class GenreResponse(
    val id: Long,
    val name: String
)
