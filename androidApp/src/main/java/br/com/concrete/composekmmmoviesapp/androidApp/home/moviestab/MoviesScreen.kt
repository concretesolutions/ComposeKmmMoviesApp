package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject

val moviesViewModel: MoviesViewModel by inject(MoviesViewModel::class.java)

@Composable
fun MoviesScreen() {
    val moviesUiState by moviesViewModel.moviesList.observeAsState(MoviesListUiState.Loading)

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
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(movies.size) { index ->
                        Text(movies[index].overview, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}