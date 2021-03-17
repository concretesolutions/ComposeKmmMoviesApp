package br.com.concrete.components.devexperience

import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppComposeScreen(
    val route: String,
    val icon: ImageVector? = null
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object EditText : AppComposeScreen("editText")
}