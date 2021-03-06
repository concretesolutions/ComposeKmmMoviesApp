package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.cache.Movies
import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse

class SearchMovieApi {

    suspend fun searchMovie(originalTitle: String): Response<MoviesResponse> =
        call(SEARCH_URL + "&query=${originalTitle}")

    private companion object {

        private val SEARCH_URL =
            "https://api.themoviedb.org/3/search/movie?api_key=1b29aa34f93afb40731208d5ab0a5c47"

    }
}