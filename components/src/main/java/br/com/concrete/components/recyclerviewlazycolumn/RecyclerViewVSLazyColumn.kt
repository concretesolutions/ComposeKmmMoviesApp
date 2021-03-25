package br.com.concrete.components.recyclerviewlazycolumn

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.concrete.components.recyclerviewlazycolumn.recycleview.RecycleViewPage


@Composable
fun ListRecyclerViewVSLazyColumn() {
    val context = LocalContext.current
    val navController = rememberNavController()
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        NavHost(navController, startDestination = AppComposeRecycleVSLazy.SampleComposeRecycleLazy.route) {
            composable(AppComposeRecycleVSLazy.SampleComposeRecycleLazy.route) {
                RecyclerViewVSLazyColumn(navController)
            }
            composable(AppComposeRecycleVSLazy.RecyclerPage.route) {
                context.startActivity(Intent(context,RecycleViewPage()::class.java))

            }
            composable(AppComposeRecycleVSLazy.LazyPage.route) {
                SetLazyColumnList()
            }
        }
    }
}



@Composable
fun RecyclerViewVSLazyColumn(navController: NavController) {
    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeRecycleVSLazy.RecyclerPage.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("RecycleView",textAlign = TextAlign.Center)

    }

    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeRecycleVSLazy.LazyPage.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("LazyColumn",textAlign = TextAlign.Center)

    }
}