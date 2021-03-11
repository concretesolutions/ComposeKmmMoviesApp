package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        content = {
            items(list) { movie ->
                MovieItemView(movieDao = movie)
            }

        })


}

@Composable
fun MovieItemView(movieDao: MovieDao) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(9.dp)
        ) {
            Column {
                val image: Painter = painterResource(movieDao.moviePicture)
                Image(
                    painter = image, contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                )
                Row {
                    Text(
                        text = movieDao.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 16.dp)


                    )
                    Spacer(modifier = Modifier.padding(45.dp, 0.dp))
                    IconButton(
                        onClick = {  /*doSomething()*/ },
                    ) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)

                    }
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
    MovieItemView(MovieDao("Interestellar", R.drawable.ic_banner_movie))
}


