package br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun SetFavoriteMovieList(movies: List<Movie>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(movies.size) { index ->
            SetFavoriteMovieView1(movie = movies[index])
        }
    }
}

@Composable
fun SetFavoriteMovieView1(movie: Movie) {
    Card {
        FavoritesCard(movie, onClick = { /*TODO*/ })
    }
}

@Composable
fun FavoritesCard(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 16.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(
                    MaterialTheme.colors.surface
                )
        ) {
            Surface(
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp),
                shape = RoundedCornerShape(8),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                CoilImage(
                    data = movie.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.Bold,
                        style = typography.h5,
                        color = Color.Black
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(0.7f)
                    )
                    Surface(
                        modifier = Modifier
                            .size(30.dp)
                            //.padding(5.dp)
                            .clickable(onClick = onClick),
                        //  color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    }
                }
                Text(
                    text = movie.releaseYear.toString(),
                    fontWeight = FontWeight.Black,
                    style = typography.body1/*TextStyle(fontSize = 17.sp)*/,
                    color = Color.Black
                )
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.medium
                ) {
                    Text(
                        text = movie.overview,
                        style = typography.body2,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(end = 25.dp)
                    )
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun SampleFavoriteMovieItem() {
////    FavoritesCard(
////        DataList("Thor", "2008","Como filho de Odin, rei dos deuses nórdicos, Thor logo herdará o trono de Asgard de seu idoso pai. Porém, no dia de sua coroação, Thor reage com brutalidade quando os inimigos dos deuses entram no palácio violando o tratado. Como punição, Odin manda Thor para a Terra. Enquanto seu irmão Loki conspira em Asgard, Thor, agora sem seus poderes, enfrenta sua maior ameaça.",
////            R.drawable.thor_poster),
////        onClick = { /*TODO*/ }
////    )
//}