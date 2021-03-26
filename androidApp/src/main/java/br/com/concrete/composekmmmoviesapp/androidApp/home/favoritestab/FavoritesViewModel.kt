package br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.concrete.composekmmmoviesapp.MoviesSdk
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val moviesSdk: MoviesSdk,
    private val moviesMapper: MoviesMapper
) : ViewModel() {

    private val _favoriteMovieList = MutableLiveData<List<Movie>>()
    val favoriteMovieList: LiveData<List<Movie>> by lazy {
        getFavorites()
        _favoriteMovieList
    }

    private fun getFavorites() {
        viewModelScope.launch {
            val favorites = moviesSdk.getFavoriteMovies()
            _favoriteMovieList.postValue(moviesMapper.mapMovieToMoviesDTO(favorites))
        }
    }


    fun removeFromFavorite(movie: Movie) {
        viewModelScope.launch {
            moviesSdk.unsaveMovie(movie.id.toLong())
            getFavorites()
        }
    }
}