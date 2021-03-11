package br.com.concrete.composekmmmoviesapp.androidApp.favoriteslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.high
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.concrete.composekmmmoviesapp.androidApp.R




@Composable
fun FavoritesCard(moviesList: DataList,onClick:() -> Unit){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 16.dp
    ){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(
                    MaterialTheme.colors.surface
                )
        ) {
            Surface(
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp),
                shape = RoundedCornerShape(8),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                Image(painter = painterResource(id = moviesList.imagePoster),
                    contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop)
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.SpaceBetween) {

                        Text(
                            text = moviesList.name,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(fontSize = 22.sp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.padding(120.dp,0.dp,0.dp,0.dp)/*.padding(70.dp,0.dp)*/)
                        Surface(
                            modifier = Modifier
                                .size(30.dp)
                                //.padding(5.dp)
                                .clickable(onClick = onClick),
                            //  color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                        ) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Favorite, contentDescription = null)

                            }
                            //Arrangement.End
                            /* Image(painter = painterResource(id = moviesList.favoritstar),
                                 contentDescription = null,
                                 modifier = Modifier
                                     .height(120.dp)
                                    // .clip(shape = RoundedCornerShape(15.dp)),
                               //  contentScale = ContentScale.Crop*/
                            //)
                        }

                        /*Row(
                            //modifier = Modifier,
                            horizontalArrangement = Arrangement.End){

                            }*/

                    }
                    Text(
                        text = moviesList.year,
                        fontWeight = FontWeight.Black,
                        style = TextStyle(fontSize = 17.sp),
                        color = Color.Black
                    )
                CompositionLocalProvider(
                   LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = moviesList.description,
                        style = typography.body2,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(end = 25.dp)
                    )
                    
                }

            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun SampleFavoriteMovieItem(){
    FavoritesCard(
        DataList("Thor", "2008","Como filho de Odin, rei dos deuses nórdicos, Thor logo herdará o trono de Asgard de seu idoso pai. Porém, no dia de sua coroação, Thor reage com brutalidade quando os inimigos dos deuses entram no palácio violando o tratado. Como punição, Odin manda Thor para a Terra. Enquanto seu irmão Loki conspira em Asgard, Thor, agora sem seus poderes, enfrenta sua maior ameaça.",
            R.drawable.thor_poster,R.drawable.ic_star_favorited),
        onClick = { /*TODO*/ }
    )
}


