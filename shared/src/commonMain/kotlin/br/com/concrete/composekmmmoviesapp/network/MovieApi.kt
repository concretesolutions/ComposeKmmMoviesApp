package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movie

class MovieApi {

    suspend fun getMovies() : Response<List<Movie>> = call(LAUNCHES_ENDPOINT)

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.themoviedb.org/3/movie/popular?api_key=1b29aa34f93afb40731208d5ab0a5c47>&language=en-US&page=1"
    }
}