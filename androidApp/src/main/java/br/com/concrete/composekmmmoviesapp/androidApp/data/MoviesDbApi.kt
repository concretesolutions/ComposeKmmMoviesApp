package br.com.concrete.composekmmmoviesapp.androidApp.data

import br.com.concrete.composekmmmoviesapp.androidApp.BuildConfig
import br.com.concrete.composekmmmoviesapp.androidApp.data.dto.MoviePage
import retrofit2.Response
import retrofit2.http.GET

interface MoviesDbApi {
    @GET("movie/popular?api_key=${BuildConfig.MoviesDbApiKey}")
    suspend fun getPopularMovies(): Response<MoviePage>
}