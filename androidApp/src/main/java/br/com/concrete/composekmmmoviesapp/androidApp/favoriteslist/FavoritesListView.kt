package br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SetFavoriteMovieListView(listView: List<DataList>){
    LazyColumn{
        items(listView){ movie ->
        FavoritesCard(moviesList = movie, onClick = { /*TODO*/ } )

        }
    }

}

@Preview
@Composable
fun SetFavoriteMovieViewPreview(){
    val list = DataList.getFavList()
    SetFavoriteMovieListView(listView = list)

}