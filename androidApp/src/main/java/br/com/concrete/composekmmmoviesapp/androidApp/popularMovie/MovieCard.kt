package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.R

@ExperimentalFoundationApi
@Composable
fun MovieListView(
    list: List<MovieDao>
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(list) { movie ->
                MovieItemView(movieDao = movie)
            }
        })


}

@Composable
fun MovieItemView(movieDao: MovieDao) {
    Card(
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val image: Painter = painterResource(movieDao.moviePicture)
            Image(
                painter = image, contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(9f / 16)
            )
            Row {
                Text(
                    text = movieDao.name,
                    textAlign = TextAlign.Center,
                    color = Color.Yellow,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 16.dp)
                        .weight(1f)
                )
                IconButton(
                    onClick = {  /*doSomething()*/ },
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)

                }
            }
        }
    }
}


@ExperimentalFoundationApi
@Preview
@Composable
fun PopularMovieItemPreview() {
    /* val movieList = MovieDao.getMovies()
     MovieListView(list = movieList)*/
    MovieItemView(MovieDao("Thor", R.drawable.ic_banner_movie))
}


