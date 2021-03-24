package br.com.concrete.composekmmmoviesapp.androidApp.utils

import androidx.test.platform.app.InstrumentationRegistry

//funcao que encontra e le o arquivo json que criamos
fun String.loadAsFixture(): String {
    val context = InstrumentationRegistry.getInstrumentation().context
    return context.assets
        //abre o arquivo:
        .open("fixtures/$this")
        //le o arquivo:
        .bufferedReader()
        .readText()
}

fun main() {
    "response_movies_success.json".loadAsFixture()
}