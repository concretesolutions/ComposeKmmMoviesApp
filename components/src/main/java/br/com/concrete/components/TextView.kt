package br.com.concrete.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TextViewCompose() {
    Text(text = "TextView Compose")
}

class TextCompose: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text)
    }
}