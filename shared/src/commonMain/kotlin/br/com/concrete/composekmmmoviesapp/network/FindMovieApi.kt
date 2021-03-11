package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movie
import br.com.concrete.composekmmmoviesapp.domain.Movies

class FindMovieApi {

    suspend fun findMovie() : Response<Movies> = call(URL)

    private companion object {

        private val URL = "https://api.themoviedb.org/3/search/movie?api_key=1b29aa34f93afb40731208d5ab0a5c47&language=en-US&query={movie_id}&page=1&include_adult=false"
    }





}