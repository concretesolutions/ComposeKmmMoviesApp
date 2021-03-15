package br.com.concrete.composekmmmoviesapp.androidApp.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


val Yellow = Color(0xfffdd835)
val YellowLight = Color(0xffffff6b)

private val primary = Yellow
private val primaryLight = YellowLight
private val textColor = Color.Black

val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primaryLight,
)

val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primaryLight,
    onPrimary = textColor
)