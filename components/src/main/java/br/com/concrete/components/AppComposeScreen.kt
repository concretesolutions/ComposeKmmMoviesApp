package br.com.concrete.components

import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppComposeScreen(
    val route: String,
    val icon: ImageVector? = null
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object EditText : AppComposeScreen("editText")
    object RecyclerVsLazy : AppComposeScreen("recyclerV")
}