package br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbDao
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.FavoritesMapper

class FavoritesViewModel(
    favoritesDao: FavoriteMovieDbDao,
    private val favoritesMapper: FavoritesMapper
) : ViewModel() {
    val favoritesLiveData = favoritesDao.getFavoriteMovies().map {
        favoritesMapper.mapDbToMovies(it)
    }
}