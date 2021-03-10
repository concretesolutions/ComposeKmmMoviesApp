package br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie

import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.R

class PopularMovieItem: AppCompatActivity(){
    @Composable
    fun PopularMovieItemfun(
        title: String
    ) {
        val image: Painter = painterResource(id = R.drawable.ic_banner_movie)
        Column(modifier = Modifier
            .background(Color.DarkGray)
            .padding(start = 0.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp)) {

            Image(painter = image, contentDescription = "")
            Row() {
                Text( text = title, color = Color.Yellow,modifier = Modifier.padding(start=72.dp,top=16.dp, end = 32.dp))
                IconButton(onClick = { /* doSomething() */ }, modifier=Modifier.padding(8.dp)) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)

                }
            }

        }


    }



    @Preview("MyScreen preview")
    @Composable
    fun PopularMovieItemPreview() {
        PopularMovieItemfun("Thor")
    }

}
