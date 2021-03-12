package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movie
import br.com.concrete.composekmmmoviesapp.domain.Movies

class FindMovieApi {

    suspend fun findMovie() : Response<Movies> = call(SEARCH_URL)

    private companion object {

        private val SEARCH_URL = "https://api.themoviedb.org/3/search/movie?api_key=1b29aa34f93afb40731208d5ab0a5c47&query={original_title}"
    }





}