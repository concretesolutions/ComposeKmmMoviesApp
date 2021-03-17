package br.com.concrete.composekmmmoviesapp

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.DatabaseDriverFactory
import br.com.concrete.composekmmmoviesapp.database.GenreDao
import br.com.concrete.composekmmmoviesapp.database.MovieDao
import br.com.concrete.composekmmmoviesapp.di.DataDriverManager
import br.com.concrete.composekmmmoviesapp.di.di
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.repository.GenreRepository
import br.com.concrete.composekmmmoviesapp.repository.MovieRepository
import org.kodein.di.instance
import org.kodein.di.newInstance

class MoviesSdk(databaseDriverFactory: DatabaseDriverFactory) {

    private val driverManager by di.newInstance { DataDriverManager(databaseDriverFactory) }
    private val movieRepository by di.newInstance {
        MovieRepository(
            instance(),
            MovieDao(driverManager)
        )
    }
    private val genreRepository by di.newInstance {
        GenreRepository(
            instance(),
            GenreDao(driverManager)
        )
    }

    suspend fun getPopularMovies(): Response<MoviesResponse> {
        return movieRepository.getPopularMovies()
    }

    suspend fun getGenresList() : Response<Genres> {
        return genreRepository.getGenresList()
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

    fun removeGenresCache() {
        genreRepository.removeAllGenres()
    }
}