package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.common.FavoriteMovieButton
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_ITEM_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_LIST_MOVIES
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalFoundationApi
@Composable
fun MovieListView(
    list: List<Movie>,
    favoriteUnfavoriteAction: (Movie) -> Unit,
    clickMovieAction: (Movie) -> Unit
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        modifier = Modifier.testTag(COMPONENT_LIST_MOVIES),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(list) { movie ->
                MovieItemView(movie = movie, favoriteUnfavoriteAction, clickMovieAction)
            }
        })
}

@Composable
fun MovieItemView(
    movie: Movie,
    favoriteUnfavoriteAction: (Movie) -> Unit,
    clickMovieAction: (Movie) -> Unit
) {
    Card(
        backgroundColor = Color(34, 20, 80),
        modifier = Modifier
            .testTag(COMPONENT_ITEM_MOVIES)
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable { clickMovieAction(movie) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            CoilImage(
                data = movie.imageUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(9f / 16)
            )
            Row {
                Text(
                    text = movie.title,
                    textAlign = TextAlign.Center,
                    color = Color.Yellow,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 16.dp)
                        .weight(1f)
                )
                Spacer(modifier = Modifier.padding(top=32.dp))
                FavoriteMovieButton(movie, favoriteUnfavoriteAction)

            }
        }
    }
}


/*@ExperimentalFoundationApi
@Preview
@Composable
fun PopularMovieItemPreview() {
    *//* val movieList = MovieDao.getMovies()
     MovieListView(list = movieList)*//*
//    MovieItemView(Movie(1,"Thor", ))
}*/
