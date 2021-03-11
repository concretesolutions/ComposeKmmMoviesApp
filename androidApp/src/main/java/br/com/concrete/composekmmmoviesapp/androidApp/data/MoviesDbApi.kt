package br.com.concrete.composekmmmoviesapp.androidApp.data

import br.com.concrete.composekmmmoviesapp.androidApp.data.dto.MoviePage
import retrofit2.Response
import retrofit2.http.GET

interface MoviesDbApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MoviePage>
}