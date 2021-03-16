package br.com.concrete.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ListComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ListComponent()
        }

    }
}

@Composable
fun ListComponent() {
    Button(onClick = {

    }) {
        Text("ListComponent")
    }
}
