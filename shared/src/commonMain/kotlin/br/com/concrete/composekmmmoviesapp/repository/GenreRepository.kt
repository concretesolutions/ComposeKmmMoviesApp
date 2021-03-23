package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.GenreDao
import br.com.concrete.composekmmmoviesapp.domain.GenresResponse
import br.com.concrete.composekmmmoviesapp.network.GenreApi

class GenreRepository (private val genreApi : GenreApi, private val genreDao: GenreDao) {

    suspend fun getGenresList(): Response<GenresResponse> {
        val genres = genreDao.getAllGenres()

        if (genres.isEmpty()) {
            val apiResult = genreApi.getGenres()

            when (apiResult) {
                is Response.Success -> genreDao.insertGenres(apiResult.data)
            }

            return apiResult
        }

        return Response.Success(GenresResponse(genres))
    }

    fun removeAllGenres() = genreDao.removeAllGenres()
}