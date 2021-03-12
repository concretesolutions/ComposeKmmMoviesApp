package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.concrete.composekmmmoviesapp.androidApp.popularMovie.MovieListView
import org.koin.java.KoinJavaComponent.inject

val moviesViewModel: MoviesViewModel by inject(MoviesViewModel::class.java)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesScreen() {
    val moviesUiState by moviesViewModel.moviesList.observeAsState(MoviesListUiState.Loading)
    var updateDb by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val uiState = moviesUiState) {
            MoviesListUiState.Loading -> {
                CircularProgressIndicator()
            }
            is MoviesListUiState.Error -> {
                Text("Error")
            }
            is MoviesListUiState.Success -> {
                val movies = uiState.moviesList
                updateDb

                MovieListView(list = movies) { movie ->
                    if (movie.isfavorite) {
                        moviesViewModel.removeFrom(movie)
                    } else {
                        moviesViewModel.addToFavorite(movie)
                    }
                    updateDb = true
                }
            }
        }
    }
}