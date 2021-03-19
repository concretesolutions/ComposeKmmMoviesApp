package br.com.concrete.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.concrete.components.devexperience.xml.XmlCompose
import br.com.concrete.components.recyclerviewlazycolumn.ListRecyclerViewVSLazyColumn

@Composable
fun ListComponents() {
    val navController = rememberNavController()
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        NavHost(navController, startDestination = AppComposeScreen.SampleComposeHome.route) {
            composable(AppComposeScreen.SampleComposeHome.route) {
                AppComposeHome(navController)
            }
            composable(AppComposeScreen.EditText.route) {
                XmlCompose()
            }
            composable(AppComposeScreen.RecyclerVsLazy.route) {
                ListRecyclerViewVSLazyColumn()
            }
        }
    }
}

@Composable
fun AppComposeHome(navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(listItems) { item ->
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                }
            ) {
                Text(item.name)
            }
        }
    }
}