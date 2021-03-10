package br.com.concrete.composekmmmoviesapp.androidApp.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab.MoviesListUiState
import br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab.MoviesViewModel
import org.koin.java.KoinJavaComponent.inject

val moviesViewModel: MoviesViewModel by inject(MoviesViewModel::class.java)

@Composable
fun MoviesScreen() {
    val moviesUiState by moviesViewModel.moviesList.observeAsState(MoviesListUiState.Loading)

    when (val uiState = moviesUiState) {
        MoviesListUiState.Loading -> {
            CircularProgressIndicator()
        }
        is MoviesListUiState.Error -> {
            Text("Error")
        }
        is MoviesListUiState.Success -> {
            val movies = uiState.moviesList
            LazyColumn(content = {
                items(movies.size) { index ->
                    Text(movies[index].title)
                }
            })
        }
    }
}