package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import br.com.concrete.composekmmmoviesapp.androidApp.popularMovie.MovieDao
import br.com.concrete.composekmmmoviesapp.androidApp.popularMovie.MovieListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val movieList = MovieDao.getMovies()
                MovieListView(list = movieList)
        }
    }
}