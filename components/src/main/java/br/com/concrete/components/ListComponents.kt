package br.com.concrete.components

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.concrete.components.design.Modifiers
import br.com.concrete.components.devexperience.xml.XmlCompose
import br.com.concrete.components.recyclerviewlazycolumn.ListRecyclerViewVSLazyColumn
import br.com.concrete.components.devexperience.xml.XmlVsCompose

@Composable
fun ListComponents() {
    val context = LocalContext.current

    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        NavHost(navController, startDestination = AppComposeScreen.SampleComposeHome.route) {
            composable(AppComposeScreen.SampleComposeHome.route) {
                AppComposeHome(navController)
            }

            composable(AppComposeScreen.XmlHome.route) {
                XmlHome(navController)

            }
            composable(AppComposeScreen.XmlCompose.route) {
                XmlCompose()

            }
            composable(AppComposeScreen.XmlComposeActivity.route) {

                context.startActivity(Intent(context, XmlVsCompose()::class.java))


            }
            composable(AppComposeScreen.RecyclerVsLazy.route) {
                ListRecyclerViewVSLazyColumn()

            }
            composable(AppComposeScreen.Modifiers.route) {
                Modifiers()
            }
            composable(AppComposeScreen.TextHome.route) {
                TextHome(navController)
            }
            composable(AppComposeScreen.TextViewText.route) {
                TextViewCompose()
            }
            composable(AppComposeScreen.TextActivity.route) {
                context.startActivity(Intent(context, TextCompose()::class.java))
            }

        }
    }
}


@Composable
fun TextHome(navController: NavController) {
    Column() {
        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.TextActivity.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }
        }) {
            Text("TextView Android")
        }
        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.TextViewText.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }
        }) {
            Text("TextView Compose")
        }
    }
}

@Composable
fun AppComposeHome(navController: NavController) {
    Column() {
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
}
