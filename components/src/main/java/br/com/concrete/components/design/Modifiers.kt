package br.com.concrete.components.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.concrete.components.R

@Composable
fun Modifiers() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Text(
            text = "Teste com modifier", modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow)
                .padding(8.dp)


        )
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
        Button(modifier = Modifier
            .background(color = Color.Green)
            .padding(16.dp)
            .fillMaxWidth(), onClick = {

        }) {
            Text(text = "TESTE MODIFIERS")
        }

        Spacer(modifier = Modifier.padding(24.dp))
        Text(
            text = "Teste com modifier", modifier = Modifier
                .padding(8.dp)
                .background(color = Color.Yellow)
                .fillMaxWidth()


        )
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(color = Color.Blue)
        )
        Button(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = Color.Green), onClick = {

        }) {
            Text(text = "TESTE MODIFIERS")
        }

    }


}

@Preview
@Composable
fun previewModifiers() {
    Modifiers()
}