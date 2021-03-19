package br.com.concrete.components

import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppComposeScreen(
    val route: String,
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object EditText : AppComposeScreen("editText")
    object TextViewText : AppComposeScreen("textViewText")
    object TextActivity : AppComposeScreen("textActivity")
    object TextHome : AppComposeScreen("textHome")
    object XmlCompose : AppComposeScreen("xmlCompose")
    object ModifiersCompose: AppComposeScreen("modifiers")
}