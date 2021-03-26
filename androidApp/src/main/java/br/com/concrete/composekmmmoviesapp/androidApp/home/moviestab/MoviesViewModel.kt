package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.concrete.composekmmmoviesapp.MoviesSdk
import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import kotlinx.coroutines.launch

sealed class MoviesListUiState {
    object Loading : MoviesListUiState()
    data class Error(@StringRes val errorRes: Int) : MoviesListUiState()
    data class Success(val moviesList: List<Movie>) : MoviesListUiState()
}

class MoviesViewModel(
    private val moviesDbRepository: MovieDbRepository,
    private val moviesSdk: MoviesSdk,
    private val moviesMapper: MoviesMapper
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
                val resultPopularMovies = moviesSdk.getPopularMovies()
                _moviesList.value =
                    MoviesListUiState.Success(moviesMapper.mapMovieToMoviesDTO(resultPopularMovies))
            } catch (ex: Throwable) {
                println(ex.printStackTrace())
                _moviesList.value = MoviesListUiState.Error(R.string.generic_error)
            }
        }
    }

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            moviesSdk.saveMovie(movieToFavoriteMovieMapper(movie))
            updateFavoriteState()
        }
    }

    fun removeFrom(movie: Movie) {
        viewModelScope.launch {
            moviesSdk.unsaveMovie(movie.id.toLong())
            updateFavoriteState()
        }
    }

    private fun updateFavoriteState() {
        viewModelScope.launch {
            val resultPopularMovies = moviesSdk.getPopularMovies()
            _moviesList.value =
                MoviesListUiState.Success(moviesMapper.mapMovieToMoviesDTO(resultPopularMovies))
        }
    }

    private fun movieToFavoriteMovieMapper(movie: Movie): FavoriteMovie = FavoriteMovie(
        id = movie.id.toLong(),
        originalTitle = movie.title,
        posterPath = movie.imageUrl,
        genres = movie.genres.joinToString { "\'${it.name}\'" },
        releaseYear = movie.releaseYear,
        overview = movie.overview
    )
}