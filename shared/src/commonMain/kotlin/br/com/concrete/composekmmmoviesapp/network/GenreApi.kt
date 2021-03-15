package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Genres

class GenreApi {

    suspend fun getGenres() : Response<Genres> = call(GENRES_URL)

    private companion object {
        private const val GENRES_URL = "https://api.themoviedb.org/3/genre/movie/list?api_key=1b29aa34f93afb40731208d5ab0a5c47&language=en-US"
    }

}