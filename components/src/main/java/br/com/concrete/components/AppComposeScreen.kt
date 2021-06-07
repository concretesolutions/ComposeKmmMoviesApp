package br.com.concrete.components

sealed class AppComposeScreen(
    val route: String,
    val name: String = "composeHome"
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object XmlHome : AppComposeScreen("xmlHome", "Xml no compose")
    object XmlComposeActivity : AppComposeScreen("xml Activity")
    object XmlCompose : AppComposeScreen("xmlCompose", "Compose")
    object TextViewText : AppComposeScreen("textViewText")
    object TextActivity : AppComposeScreen("textActivity")
    object TextHome : AppComposeScreen("textHome", "Text")
    object ModifiersCompose : AppComposeScreen("modifiers", "Modifiers")
}

val listItems = listOf(
    AppComposeScreen.ModifiersCompose,
    AppComposeScreen.TextHome,
    AppComposeScreen.XmlHome
)
