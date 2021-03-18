package br.com.concrete.components.recyclerview

import androidx.compose.ui.graphics.vector.ImageVector
import br.com.concrete.components.AppComposeScreen


sealed class AppComposeRecycleVSLazy(
    val route: String,
    val icon: ImageVector? = null
) {
    object SampleComposeRecycleLazy : AppComposeRecycleVSLazy("composeHome")
    object RecyclerPage : AppComposeRecycleVSLazy("recyclerPage")
    object LazyPage : AppComposeRecycleVSLazy("lazyPage")
}
