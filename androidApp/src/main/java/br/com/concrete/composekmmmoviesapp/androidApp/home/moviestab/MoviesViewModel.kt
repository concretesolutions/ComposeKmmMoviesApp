package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MoviesDbApi
import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbDao
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.FavoritesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import kotlinx.coroutines.launch

sealed class MoviesListUiState {
    object Loading : MoviesListUiState()
    data class Error(@StringRes val errorRes: Int) : MoviesListUiState()
    data class Success(val moviesList: List<Movie>) : MoviesListUiState()
}

class MoviesViewModel(
    private val api: MoviesDbApi,
    private val mapper: MoviesMapper,
    private val favoriteDao: FavoriteMovieDbDao,
    private val favoritesMapper: FavoritesMapper
) : ViewModel() {
    val moviesList: LiveData<MoviesListUiState> = liveData {
        emit(MoviesListUiState.Loading)
        try {
            val popularMovies = api.getPopularMovies().body()
            val genres = api.getGenres().body()
            if (popularMovies != null && genres != null) {
                emit(MoviesListUiState.Success(mapper.mapMoviesDtoToMovie(popularMovies, genres)))
            }
        } catch (ex: Throwable) {
            emit(MoviesListUiState.Error(R.string.generic_error))
        }
    }

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            val movieDbEntity = favoritesMapper.mapMovieToDbEntity(movie)
            favoriteDao.insertFavorite(movieDbEntity)
        }
    }
    fun removeFrom(movie: Movie) {
        viewModelScope.launch {
            val movieDbEntity = favoritesMapper.mapMovieToDbEntity(movie)
            favoriteDao.deleteFavorite(movieDbEntity)
        }
    }
}