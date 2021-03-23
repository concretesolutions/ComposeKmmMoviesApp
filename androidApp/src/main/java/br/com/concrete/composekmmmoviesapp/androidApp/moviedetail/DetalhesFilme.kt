package br.com.concrete.composekmmmoviesapp.androidApp.moviedetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.common.FavoriteMovieButton
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.domain.MovieResponse
import br.com.concrete.composekmmmoviesapp.androidApp.util.DataSamples
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun MovieDetailScreen(movie: Movie, onClickFavorite: (Movie) -> Unit) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageModifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            CoilImage(
                data = movie.imageUrl,
                modifier = imageModifier,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))


            Row() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start)
                        .align(Alignment.CenterVertically),
                    text = movie.title,
                    style = typography.h4,
                    fontWeight = FontWeight.Bold
                )
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically)
                ) {
                    FavoriteMovieButton(movie, onClickFavorite)
                }

            }
            Text(
                "Ano",
                style = typography.h6
            )
            Text(
                movie.releaseYear.toString(),
                style = typography.body2
            )
            Text(
                "Genero",
                style = typography.h6
            )
            Text(
                movie.genres.joinToString { it.name },
                style = typography.body2
            )
            Text(
                "Sinopse e Detalhes",
                style = typography.h6
            )
            Text(
                movie.overview,
                style = typography.body2
            )
        }
    }
}

@Preview
@Composable
fun DefultPreview() {
    MovieDetailScreen(DataSamples.movie, {})
}