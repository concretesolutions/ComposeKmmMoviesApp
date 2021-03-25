package br.com.concrete.composekmmmoviesapp.androidApp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesApp()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("APP", "onResume")
    }
}
