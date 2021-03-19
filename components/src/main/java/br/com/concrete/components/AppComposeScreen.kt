package br.com.concrete.components

sealed class AppComposeScreen(
    val route: String,
    val name: String = "composeHome"
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object XmlCompose : AppComposeScreen("xmlCompose", "Xml no compose")
    object RecyclerVsLazy : AppComposeScreen("recyclerV", "RecyclerView vs LazyComponents")
    object Modifiers : AppComposeScreen("modifiersCompose", "Modifiers")
}

val listItems = listOf(
    AppComposeScreen.XmlCompose,
    AppComposeScreen.RecyclerVsLazy, 
    AppComposeScreen.Modifiers, 
)