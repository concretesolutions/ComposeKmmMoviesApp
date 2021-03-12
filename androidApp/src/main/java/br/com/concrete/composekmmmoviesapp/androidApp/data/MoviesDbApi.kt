package br.com.concrete.composekmmmoviesapp.androidApp.data

import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.GenreDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.MoviePageDto
import retrofit2.Response
import retrofit2.http.GET

interface MoviesDbApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MoviePageDto>

    @GET("genre/movie/list")
    suspend fun getGenres(): Response<GenreDto>
}