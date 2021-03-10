package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movie
import br.com.concrete.composekmmmoviesapp.network.MovieApi

class MovieRepository(private val movieApi: MovieApi) {

    suspend fun getPopularMovies(): Response<List<Movie>> = movieApi.getMovies()
}