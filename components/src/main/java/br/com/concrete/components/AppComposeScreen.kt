package br.com.concrete.components


sealed class AppComposeScreen(
    val route: String,
    val name: String = "composeHome"
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object XmlCompose : AppComposeScreen("xmlCompose", "Xml no compose")
    object ModifiersCompose: AppComposeScreen("modifiers", "Modifiers")
}

val listItems = listOf(
    AppComposeScreen.XmlCompose,
    AppComposeScreen.ModifiersCompose,
)