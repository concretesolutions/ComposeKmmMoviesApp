package br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val movieDbRepository: MovieDbRepository
) : ViewModel() {
    val favoritesLiveData = movieDbRepository.getFavoriteMoviesLiveData()

    fun removeFromFavorite(movie: Movie) {
        viewModelScope.launch {
            movieDbRepository.removeFromFavorite(movie)
        }
    }
}