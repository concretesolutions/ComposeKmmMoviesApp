package br.com.concrete.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
               // RecyclerViewVSLazyColumn(navController)
            }
        }
    }
}


@Composable
fun AppComposeHome(navController: NavController) {

    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeScreen.EditText.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("XML no Compose")

    }

    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeScreen.RecyclerVsLazy.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("RecycleView \n vs \n LazyColumn",textAlign = TextAlign.Center)

    }
}