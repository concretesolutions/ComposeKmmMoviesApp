package br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist.SetFavoriteMovieList
import org.koin.java.KoinJavaComponent.inject

val favoritesViewModel: FavoritesViewModel by inject(FavoritesViewModel::class.java)

@Composable
fun FavoritesScreen(navController: NavController) {
    val favorites by favoritesViewModel.favoritesLiveData.observeAsState()

    val favoriteList = favorites
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (favoriteList.isNullOrEmpty()) {
            Text("Empty")
        } else {
            SetFavoriteMovieList(favoriteList, onClickCard = { movie ->
                navController.currentBackStackEntry
                    ?.arguments?.putParcelable("movie", movie)
                navController.navigate("detail")
            },
                onClickFavorite = { movie ->
                    favoritesViewModel.removeFromFavorite(movie)
                })
        }
    }
}