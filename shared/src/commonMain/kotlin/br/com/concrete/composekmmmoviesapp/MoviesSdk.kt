package br.com.concrete.composekmmmoviesapp

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.di.di
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import br.com.concrete.composekmmmoviesapp.repository.MovieRepository
import org.kodein.di.instance
import org.kodein.di.newInstance

class MoviesSdk {

    private val movieRepository by di.newInstance { MovieRepository(instance(), instance()) }

    suspend fun getPopularMovies(): Response<MoviesResponse> {
        return movieRepository.getPopularMovies()
    }

    suspend fun getGenreList() {
        TODO()
    }

    fun saveMovie(favoriteMovie: FavoriteMovie) {
        movieRepository.saveFavoriteMovie(favoriteMovie)
    }

    fun unsaveMovie(idMovie: Long) {
        movieRepository.unsaveFavoriteMovie(idMovie)
    }

    fun getFavoriteMovies(): List<FavoriteMovie> = movieRepository.getFavoriteMovies()


    suspend fun findMovie() {
        TODO()
    }
}