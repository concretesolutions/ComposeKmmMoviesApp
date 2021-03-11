package br.com.concrete.composekmmmoviesapp.androidApp.detalhesFilme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.shared.Greeting

class DetalhesFilme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory(
                R.drawable.filme,
                filme = "Se Enlouquecer, Não se Apaixone",
                ano = "2010",
                genero = "Drama, Romance",
                sinopse = "Craig (Keir Gilchrist), estressado com as demandas de" +
                        " ser um adolescente e assustado com sua tendência suicida," +
                        " decide buscar ajuda em uma clínica psiquiátrica." +
                        " Internado por uma semana, ele logo é acolhido por" +
                        " Bobby (Zach Galifianakis), que se torna seu mentor," +
                        " e se encanta com Noelle (Emma Roberts)"
            )
        }
    }

}

@Composable
fun NewsStory(
    image: Int,
    filme: String,
    ano: String,
    genero: String,
    sinopse: String
) {
    val image = painterResource(image)
    MaterialTheme() {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageModifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                image,
                modifier = imageModifier,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))


            Text(
                filme,
                style = typography.h6, maxLines = 2
            )
            Text(
                "Ano",
                style = typography.h6
            )
            Text(
                ano,
                style = typography.body2
            )
            Text(
                "Genero",
                style = typography.h6
            )
            Text(
                genero,
                style = typography.body2
            )
            Text(
                "Sinopse e Detalhes",
                style = typography.h6
            )
            Text(
                sinopse,
                style = typography.body2
            )
        }
    }
}

@Preview
@Composable
fun DefultPreview() {
    NewsStory(
        R.drawable.filme,
        filme = "Se Enlouquecer, Não se Apaixone",
        ano = "2010",
        genero = "Drama, Romance",
        sinopse = "Craig (Keir Gilchrist), estressado com as demandas de" +
                " ser um adolescente e assustado com sua tendência suicida," +
                " decide buscar ajuda em uma clínica psiquiátrica." +
                " Internado por uma semana, ele logo é acolhido por" +
                " Bobby (Zach Galifianakis), que se torna seu mentor," +
                " e se encanta com Noelle (Emma Roberts)"
    )
}