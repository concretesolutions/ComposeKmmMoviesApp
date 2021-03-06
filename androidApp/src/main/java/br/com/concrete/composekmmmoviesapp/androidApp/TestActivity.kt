package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import br.com.concrete.composekmmmoviesapp.MoviesSdk
import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.database.DatabaseDriverFactory
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class TestActivity : ComponentActivity() {

    private val mainScope = MainScope()
    private val moviesSdk = MoviesSdk(DatabaseDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                    moviesSdk.saveMovie(
                        FavoriteMovie(
                            1,
                            "",
                            "Panico",
                            "Action,Horror",
                            2002,
                            "teste"
                        )
                    )
                    moviesSdk.saveMovie(
                        FavoriteMovie(
                            2,
                            "",
                            "SilentHill",
                            "Action,Horror",
                            2002,
                            "teste"
                        )
                    )
                    moviesSdk.saveMovie(
                        FavoriteMovie(
                            3,
                            "",
                            "JurassicPark",
                            "Action,Horror",
                            2002,
                            "teste"
                        )
                    )
                }) {
                    Text("Save")
                }

                Button(onClick = {
                    moviesSdk.getFavoriteMovies().forEach {
                        Toast.makeText(
                            this@TestActivity,
                            it.originalTitle,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }) {
                    Text("Favorites")
                }

                Button(onClick = {
                    moviesSdk.unsaveMovie(3)
                }) {
                    Text("Unsave")
                }
            }
        }


        mainScope.launch {
            val response: Response<MoviesResponse> = moviesSdk.getPopularMovies()
            if (response is Response.Success)
                Toast.makeText(
                    this@TestActivity,
                    response.data.results[0].originalTitle,
                    Toast.LENGTH_SHORT
                ).show()
            else
                Toast.makeText(this@TestActivity, "ERRO", Toast.LENGTH_SHORT).show()
        }

        mainScope.launch {
            val response: Response<Genres> = moviesSdk.getGenresList()
            if (response is Response.Success)
                Toast.makeText(this@TestActivity, response.data.genres[0].name, Toast.LENGTH_SHORT)
                    .show()
        }

        mainScope.launch {
            val response : Response<MoviesResponse> = moviesSdk.searchMovie("soul")
            if(response is Response.Success)
                Toast.makeText(this@TestActivity,response.data.results[0].originalTitle,Toast.LENGTH_LONG).show()
        }
    }


}