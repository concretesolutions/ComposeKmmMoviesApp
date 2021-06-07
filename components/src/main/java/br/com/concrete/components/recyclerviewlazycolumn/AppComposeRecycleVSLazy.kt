package br.com.concrete.components.recyclerviewlazycolumn

import androidx.compose.ui.graphics.vector.ImageVector


sealed class AppComposeRecycleVSLazy(
    val route: String,
    val icon: ImageVector? = null
) {
    object SampleComposeRecycleLazy : AppComposeRecycleVSLazy("composeHome")
    object RecyclerPage : AppComposeRecycleVSLazy("recyclerPage")
    object LazyPage : AppComposeRecycleVSLazy("lazyPage")
}
