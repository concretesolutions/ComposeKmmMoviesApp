package br.com.concrete.composekmmmoviesapp.androidApp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie.MovieCard
import br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie.MovieData
import br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie.PopularMovieItem
import br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie.ViewModelMovie
import br.com.concrete.composekmmmoviesapp.shared.Greeting

class MainActivity : AppCompatActivity() {
    private val movieView:ViewModelMovie by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetMovieCard()

        }
    }

    @Preview
    @Composable
    fun SetMovieCard(){
        val movieDatas = movieView.movieList.value
        setMovieList(movieList = movieDatas!!)}

        @OptIn(ExperimentalFoundationApi::class)
        @Composable
        fun setMovieList(movieList: List<MovieData>){
            LazyColumn{

                }

            }
    }
