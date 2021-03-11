package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.R

/*@ExperimentalFoundationApi
@Composable
fun Board(board: Array<IntArray>) {
    LazyVerticalGrid(cells = GridCells.Fixed(Game2048.BOARD_SIZE),
        modifier = Modifier
            .clip(shapes.large)
            .background(color = ProjectColors.surface)
            .padding(4.dp),
        content = {
            items(Game2048.BOARD_SIZE * Game2048.BOARD_SIZE) { index ->

            }
        })
}*/

@ExperimentalFoundationApi
@Composable
fun MovieListView(
    list: List<MovieDao>
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        content = {
                items(list) { movie ->
                    MovieItemView(movieDao = movie)
            }

        })


}

@Composable
fun MovieItemView(movieDao: MovieDao) {
    Card {
        Column(
            modifier = Modifier
                .background(Color.DarkGray)
        ) {
            val image: Painter = painterResource(movieDao.moviePicture)
            Image(
                painter = image, contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Row() {
                Text(
                    text = movieDao.name,
                    color = Color.Yellow,
                    textAlign = TextAlign.Center
                    //modifier = Modifier.weight(1F)

                )
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)

                }
            }

        }

    }

}


@Preview
@Composable
fun PopularMovieItemPreview() {
    MovieItemView(MovieDao("Thor", R.drawable.ic_banner_movie))
}


