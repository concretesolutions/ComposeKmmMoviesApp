package br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab

import androidx.lifecycle.ViewModel
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository

class FavoritesViewModel(
    movieDbRepository: MovieDbRepository
) : ViewModel() {
    val favoritesLiveData = movieDbRepository.getFavoriteMovies()
}