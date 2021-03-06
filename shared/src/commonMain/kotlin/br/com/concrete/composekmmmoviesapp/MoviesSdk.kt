package br.com.concrete.composekmmmoviesapp

import br.com.concrete.composekmmmoviesapp.cache.Movies
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
import br.com.concrete.composekmmmoviesapp.repository.SearchMovieRepository
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
    private val SearchMovieRepository by di.newInstance { SearchMovieRepository(instance()) }


    suspend fun getPopularMovies(page:Int = 1): Response<MoviesResponse> {
        return movieRepository.getPopularMovies(page)
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

    suspend fun searchMovie(originalTitle: String) : Response<MoviesResponse>{
        return SearchMovieRepository.searchMovies(originalTitle)
    }


}