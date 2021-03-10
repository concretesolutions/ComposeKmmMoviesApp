package br.com.concrete.composekmmmoviesapp.androidApp.data

import retrofit2.http.GET

interface ApiService {
    @GET()
    suspend fun getPopularMovies()
}