package br.com.concrete.components

sealed class AppComposeScreen(
    val route: String,
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object XmlCompose : AppComposeScreen("xmlCompose")
    object XmlHome: AppComposeScreen("xmlHome")
    object XmlComposeActivity: AppComposeScreen("xmlComposeActivity")
    object ModifiersCompose: AppComposeScreen("modifiers")
}