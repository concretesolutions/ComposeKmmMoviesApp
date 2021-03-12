package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    @StringRes val titleRes: Int,
    val icon: ImageVector = Icons.Default.Movie
) {
    object Movies : Screen("movies", R.string.title_tab_movies, Icons.Default.Movie)
    object Favorites : Screen("favorites", R.string.title_tab_favorites, Icons.Default.Favorite)
    object Detail : Screen("detail", R.string.title_tab_favorites)
}

val bottomBarItems = listOf(
    Screen.Movies,
    Screen.Favorites,
)