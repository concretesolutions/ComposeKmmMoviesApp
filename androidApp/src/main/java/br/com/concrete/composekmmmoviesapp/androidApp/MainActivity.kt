package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import br.com.concrete.composekmmmoviesapp.androidApp.popularMovie.MovieDao
import br.com.concrete.composekmmmoviesapp.androidApp.popularMovie.MovieListView

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val movieList = MovieDao.getMovies()
                MovieListView(list = movieList)
        }
    }
}