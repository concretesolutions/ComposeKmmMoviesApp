package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import br.com.concrete.composekmmmoviesapp.androidApp.R

/*@Composable
fun CharactersList(
    items: List<MovieDao> = listOf(),
    cols: Int = 2
) {
    val movieList = items.chunked(cols)
    LazyColumn(items = chunkedList) {
        Row {
            for(character in it) {
                MovieItemView(character)
            }
        }
    }
}*/
@Composable
fun MovieListView(
    list: List<MovieDao>
) {
    val colunas = 2
    LazyColumn (){
        items(list.chunked(colunas)) { movie ->
            Row() {
                for (movie in list){
                    MovieItemView(movieDao = movie)
                }

            }

        }
    }
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
                    modifier = Modifier.weight(1F)

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


/*@Composable
fun GridLayoutComponent(movieDao: List<MovieDao>) {
    val numberOfColumns = 2
    Table(columns = numberOfColumns) {
        for (i in movieDao.indices step numberOfColumns) {
            tableRow {
                for (j in 0 until numberOfColumns)
                   }
                }
            }
        }
    }*/
