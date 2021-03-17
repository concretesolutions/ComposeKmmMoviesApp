package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import kotlinx.coroutines.launch

sealed class MoviesListUiState {
    object Loading : MoviesListUiState()
    data class Error(@StringRes val errorRes: Int) : MoviesListUiState()
    data class Success(val moviesList: List<Movie>) : MoviesListUiState()
}

class MoviesViewModel(
    private val moviesDbRepository: MovieDbRepository
) : ViewModel() {
    private val _moviesList = MutableLiveData<MoviesListUiState>()
    val moviesList: LiveData<MoviesListUiState> by lazy {
        getMoviesListState()
        _moviesList
    }

     private fun getMoviesListState() {
        viewModelScope.launch {
            _moviesList.value = MoviesListUiState.Loading
            try {
                val resultPopularMovies = moviesDbRepository.getPopularMovies()
                _moviesList.value = MoviesListUiState.Success(resultPopularMovies)
            }catch (ex: Throwable){
                _moviesList.value = MoviesListUiState.Error(R.string.generic_error)
            }
        }
    }

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            moviesDbRepository.addToFavorite(movie)
            updateFavoriteState()
        }
    }

    fun removeFrom(movie: Movie) {
        viewModelScope.launch {
            moviesDbRepository.removeFromFavorite(movie)
            updateFavoriteState()
        }
    }

    private fun updateFavoriteState() {
        viewModelScope.launch {
            val resultPopularMovies = moviesDbRepository.getPopularMovies()
            _moviesList.value = MoviesListUiState.Success(resultPopularMovies)
        }
    }
}