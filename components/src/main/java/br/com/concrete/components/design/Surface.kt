package br.com.concrete.components.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SurfaceModifiers() {
    Column() {
        Card(
            backgroundColor = Color(34, 20, 80),
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .fillMaxWidth()

        ) {
            Text(text = "Teste com surface", color = Color.White)

        }
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .fillMaxWidth()
        ) {
            Surface(contentColor = Color(34, 20, 80)) {
                Text(text = "Teste com surface",  color = Color.White)

            }


        }

    }

}
