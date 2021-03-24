package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_MOVIES
import org.koin.java.KoinJavaComponent.inject

val moviesViewModel: MoviesViewModel by inject(MoviesViewModel::class.java)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesScreen(navController: NavController) {
    val moviesUiState by moviesViewModel.moviesList.observeAsState(MoviesListUiState.Loading)
       // val moviesUiState:MoviesListUiState = MoviesListUiState.Error(0)
    Box(
        modifier = Modifier.testTag(SCREEN_MOVIES).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Log.d("AppMovieNovo","movieUiState: $moviesUiState")
        when (val uiState = moviesUiState) {
            MoviesListUiState.Loading -> {
                Log.d("AppMovieNovo","Loading View")
                CircularProgressIndicator()
            }
            is MoviesListUiState.Error -> {
                Log.d("AppMovieNovo","Erro View")
                Text("Error")
            }
            is MoviesListUiState.Success -> {
                val movies = uiState.moviesList
                Log.d("AppMovieNovo","SUCCESS")
                MovieListView(list = movies, favoriteUnfavoriteAction = { movie ->
                    if (movie.isfavorite) {
                        moviesViewModel.removeFrom(movie)
                    } else {
                        moviesViewModel.addToFavorite(movie)
                    }
                },
                    clickMovieAction = { movie ->
                        navController.currentBackStackEntry
                            ?.arguments?.putParcelable("movie", movie)
                        navController.navigate("detail")
                    })
            }
        }
    }
}