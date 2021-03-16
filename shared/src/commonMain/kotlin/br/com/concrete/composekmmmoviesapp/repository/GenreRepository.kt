package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.GenreDao
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.network.GenreApi

class GenreRepository (private val genreApi : GenreApi, private val genreDao: GenreDao) {

    suspend fun getGenresList(): Response<Genres> = genreApi.getGenres()

    fun removeAllGenres() = genreDao.removeAllGenres()

}