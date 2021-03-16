package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab.FavoritesScreen
import br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab.favoritesViewModel
import br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab.MoviesScreen
import br.com.concrete.composekmmmoviesapp.androidApp.moviedetail.MovieDetailScreen
import br.com.concrete.composekmmmoviesapp.androidApp.theme.ComposeMoviesAppTheme

@Preview(device = Devices.PIXEL_4_XL)
@Composable
fun MoviesApp() {
    val navController = rememberNavController()
    ComposeMoviesAppTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }) },
            bottomBar = { MoviesAppBottomBar(navController) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp)
            ) {
                NavHost(navController, startDestination = Screen.Movies.route) {
                    composable(Screen.Movies.route) { MoviesScreen(navController) }
                    composable(Screen.Favorites.route) { FavoritesScreen(navController) }
                    composable("detail") {
                        val movie = navController.previousBackStackEntry
                            ?.arguments?.getParcelable<Movie>("movie")

                        if (movie != null) {
                            MovieDetailScreen(
                                movie,
                                onClickFavorite = { movie ->
                                    favoritesViewModel.removeFromFavorite(movie)
                                })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MoviesAppBottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    BottomNavigation {
        bottomBarItems.forEach { screen ->
            val title = stringResource(id = screen.titleRes)
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                modifier = Modifier.testTag("Button-$title"),
                icon = { Icon(imageVector = screen.icon, title) },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                },
                label = { Text(stringResource(screen.titleRes)) }
            )
        }
    }
}

@Composable
fun MoviesList(navController: NavController) {
    Button(onClick = {
        navController.navigate(Screen.Detail.route)
    }) {
        Text("Go to detail")
    }
}

@Composable
fun Favorites() {
    Text("Favorites")
}