package br.com.concrete.components

sealed class AppComposeScreen(
    val route: String,
    val name: String = "composeHome"
) {
    object SampleComposeHome : AppComposeScreen("composeHome")
    object EditText : AppComposeScreen("editText", "EditText vs TextField")
    object RecyclerVsLazy : AppComposeScreen("recyclerV", "RecyclerView vs LazyComponents")
}

val listItems = listOf(
    AppComposeScreen.EditText,
    AppComposeScreen.RecyclerVsLazy,
)