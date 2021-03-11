package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist.DataList
import br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist.FavoritesCard
import br.com.concrete.composekmmmoviesapp.androidApp.ui.theme.MyTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyTheme {
               SetFavoriteMovieList()

           }
        }
    }
}

@Preview
@Composable
fun SetFavoriteMovieList(){
    LazyColumn{
        items(DataList.getFavList().size){
            index ->
            SetFavoriteMovieView1(datalist = DataList.getFavList()[index])

        }
    }

}


@Composable
fun SetFavoriteMovieView1(datalist: DataList){
    Card() {
        FavoritesCard(moviesList = datalist, onClick = { /*TODO*/ })
    }

}
