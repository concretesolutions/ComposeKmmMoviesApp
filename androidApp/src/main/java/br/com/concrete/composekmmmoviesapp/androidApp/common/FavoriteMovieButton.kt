package br.com.concrete.composekmmmoviesapp.androidApp.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.theme.Yellow
import br.com.concrete.composekmmmoviesapp.androidApp.util.DataSamples

@Composable
fun FavoriteMovieButton(
    movie: Movie = DataSamples.movie,
    action: (Movie) -> Unit
) {
    IconButton(
        onClick = { action(movie) },
        modifier = Modifier
            .size(48.dp),




    ) {
        val tintIcon = if (movie.isfavorite) {
            Yellow
        } else {
            Color.LightGray
        }
        Icon(
            Icons.Filled.Favorite,
            contentDescription = stringResource(R.string.icon_description),
            tint = tintIcon,

        )
    }
}