package br.com.concrete.composekmmmoviesapp.androidApp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.White
)

private val LightColorPalette = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondaryVariant = Red900,
    onSecondary = Color.White,
    surface = Red300,
    background = Red200
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(),content: @Composable() () -> Unit ){
    val colors = if (darkTheme){
        DarkColorPalette
    }else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
