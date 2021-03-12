package br.com.concrete.composekmmmoviesapp.androidApp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbDao
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.FavoritesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDbRepository(
    private val api: MoviesDbApi,
    private val mapper: MoviesMapper,
    private val favoriteDao: FavoriteMovieDbDao,
    private val favoritesMapper: FavoritesMapper
) {
    suspend fun getPopularMovies(): List<Movie> = withContext(Dispatchers.IO) {
        try {
            val popularMovies = api.getPopularMovies().body()
            val genres = api.getGenres().body()
            val favoriteMovies = favoriteDao.getFavoriteMovies().map {
                favoritesMapper.mapDbToMovie(it)
            }
            if (popularMovies != null && genres != null) {
                val mapMovies = mapper.mapMoviesDtoToMovie(popularMovies, favoriteMovies, genres)
                mapMovies
            } else {
                emptyList()
            }
        } catch (ex: Throwable) {
            emptyList()
        }
    }

    suspend fun addToFavorite(movie: Movie) {
        val movieDbEntity = favoritesMapper.mapMovieToDbEntity(movie)
        favoriteDao.insertFavorite(movieDbEntity)
    }

    suspend fun removeFromFavorite(movie: Movie) {
        val movieDbEntity = favoritesMapper.mapMovieToDbEntity(movie)
        favoriteDao.deleteFavorite(movieDbEntity)
    }

    fun getFavoriteMoviesLiveData(): LiveData<List<Movie>> {
        return favoriteDao.getFavoriteMoviesLiveData().map {
            favoritesMapper.mapDbToMovies(it)
        }
    }
}