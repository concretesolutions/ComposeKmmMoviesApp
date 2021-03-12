package br.com.concrete.composekmmmoviesapp.androidApp.moviedetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.util.DataSamples
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun NewsStory(movie: Movie) {

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


            Text(
                text = movie.title,
                style = typography.h6, maxLines = 2
            )
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
                movie.genres.joinToString(),
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
    NewsStory(DataSamples.movie)
}