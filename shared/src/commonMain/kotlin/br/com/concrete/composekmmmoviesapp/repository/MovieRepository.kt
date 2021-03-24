package br.com.concrete.composekmmmoviesapp.repository

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.MovieDao
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.Movie
import br.com.concrete.composekmmmoviesapp.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.network.MovieApi

class MovieRepository(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
    private val genreRepository: GenreRepository,
    private val mapper: MoviesMapper,
) {

    suspend fun getPopularMovies(page: Int): List<Movie> {
        val popularMovies = movieApi.getMovies(page)
        val genres = genreRepository.getGenresList()
        val favorites = movieDao.getAllFavoriteMovies()

        return if ((popularMovies is Response.Success) && (genres is Response.Success)) {
            mapper.mapMoviesDtoToMovie(
                popularMovies.data,
                favorites, genres.data
            )
        } else {
            listOf()
        }
    }

    fun saveFavoriteMovie(favoriteMovie: FavoriteMovie) {
        movieDao.insertFavoriteMovie(favoriteMovie)
    }

    fun unsaveFavoriteMovie(idMovie: Long) {
        movieDao.removeFavoriteMovie(idMovie)
    }

    suspend fun getFavoriteMovies(): List<Movie> {
        val genres = genreRepository.getGenresList()
        val favoriteMovie = movieDao.getAllFavoriteMovies()


        return if ((genres is Response.Success)) {
            mapper.mapFavoriteDtoToMovie(
                favoriteMovies = favoriteMovie,
                genresResponse = genres.data
            )
        } else {
            listOf()
        }
    }
}
