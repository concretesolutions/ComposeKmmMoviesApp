package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import br.com.concrete.composekmmmoviesapp.network.SearchMovieApi

class SearchMovieRepository(private val searchMovieApi: SearchMovieApi) {

    suspend fun searchMovies(originalTitle : String): Response<MoviesResponse> = searchMovieApi.searchMovie(originalTitle)


}