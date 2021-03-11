package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import br.com.concrete.composekmmmoviesapp.MoviesSdk
import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.domain.Movies
import br.com.concrete.composekmmmoviesapp.shared.Greeting
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {

    private val mainScope = MainScope()
    private val moviesSdk = MoviesSdk()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(greet())
        }

        mainScope.launch {
              val response : Response<Movies> = moviesSdk.getPopularMovies()
            if(response is Response.Success)
             Toast.makeText(this@MainActivity,response.data.results[0].originalTitle,Toast.LENGTH_SHORT).show()
       }

        mainScope.launch {
            val response : Response<Genres> = moviesSdk.getGenresList()
         if(response is Response.Success)
          Toast.makeText(this@MainActivity,response.data.genres[0].name,Toast.LENGTH_SHORT).show()

        }

        mainScope.launch {
            val response : Response<Movies> = moviesSdk.findMovie()
            if(response is Response.Success)
                Toast.makeText(this@MainActivity,response.data.results[0].originalTitle,Toast.LENGTH_LONG).show()

        }
    }
}
