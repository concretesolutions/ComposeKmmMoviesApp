package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.MovieDao
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import br.com.concrete.composekmmmoviesapp.network.MovieApi

class MovieRepository(private val movieApi: MovieApi, private val movieDao: MovieDao) {

    suspend fun getPopularMovies(page:Int): Response<MoviesResponse> = movieApi.getMovies(page)

    fun saveFavoriteMovie(favoriteMovie: FavoriteMovie) {
        movieDao.insertFavoriteMovie(favoriteMovie)
    }

    fun unsaveFavoriteMovie(idMovie:Long) {
        movieDao.removeFavoriteMovie(idMovie)
    }

    fun getFavoriteMovies() : List<FavoriteMovie> = movieDao.getAllFavoriteMovies()

}