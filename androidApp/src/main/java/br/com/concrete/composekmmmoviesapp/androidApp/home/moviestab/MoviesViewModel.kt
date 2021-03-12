package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
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
    val moviesList: LiveData<MoviesListUiState> = liveData {
        emit(MoviesListUiState.Loading)
        val resultPopularMovies = moviesDbRepository.getPopularMovies()

//        if (resultPopularMovies.isSuccess) {
            emit(MoviesListUiState.Success(resultPopularMovies))
//        } else {
//            emit(MoviesListUiState.Error(R.string.generic_error))
//        }
    }

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            moviesDbRepository.addToFavorite(movie)
        }
    }

    fun removeFrom(movie: Movie) {
        viewModelScope.launch {
            moviesDbRepository.removeFromFavorite(movie)
        }
    }
}