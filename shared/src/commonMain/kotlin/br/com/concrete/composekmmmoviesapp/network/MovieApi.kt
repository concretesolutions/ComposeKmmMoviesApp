package br.com.concrete.composekmmmoviesapp.network

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import io.ktor.client.*

class MovieApi(private val httpClient: HttpClient) {

    suspend fun getMovies(page: Int): Response<MoviesResponse> =
        call(MOVIES_URL + "&page=$page", httpClient)

    private companion object {
        private const val MOVIES_URL =
            "https://api.themoviedb.org/3/movie/popular?api_key=1b29aa34f93afb40731208d5ab0a5c47&language=en-US"
    }
}
