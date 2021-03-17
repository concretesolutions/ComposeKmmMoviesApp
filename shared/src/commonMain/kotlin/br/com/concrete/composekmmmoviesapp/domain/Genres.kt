package br.com.concrete.composekmmmoviesapp.domain

import kotlinx.serialization.Serializable

@Serializable
data class Genres (
    val genres: List<Genre>
        )

@Serializable
data class Genre (
    val id: Long,
    val name: String
     )
