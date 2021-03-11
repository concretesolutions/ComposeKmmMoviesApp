package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.network.GenreApi

class GenreRepository (private val genreApi : GenreApi) {

    suspend fun getGenresList(): Response<Genres> = genreApi.getGenres()


}