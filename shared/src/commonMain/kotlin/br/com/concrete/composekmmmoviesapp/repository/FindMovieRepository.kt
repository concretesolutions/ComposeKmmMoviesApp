package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movies
import br.com.concrete.composekmmmoviesapp.network.FindMovieApi

class FindMovieRepository (private val findMovieApi: FindMovieApi) {

    suspend fun findMovies(): Response<Movies> = findMovieApi.findMovie()


}