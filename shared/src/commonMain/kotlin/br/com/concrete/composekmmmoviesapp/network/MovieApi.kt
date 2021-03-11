package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse

class MovieApi {

    suspend fun getMovies() : Response<MoviesResponse> = call(MOVIES_URL)

    companion object {
        private const val MOVIES_URL = "https://api.themoviedb.org/3/movie/popular?api_key=1b29aa34f93afb40731208d5ab0a5c47&language=en-US&page=1"
    }
}