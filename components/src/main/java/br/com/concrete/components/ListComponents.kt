package br.com.concrete.components

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.concrete.components.devexperience.xml.XmlCompose

@Composable
fun ListComponents() {
    val navController = rememberNavController()
    val context = LocalContext.current
    Column(
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
fun TextHome(navController: NavController){
    Column {


        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.TextActivity.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }


        }) {
            Text("Text na activity")

        }
        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.TextViewText.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }


        }) {
            Text("TextView no Compose")

        }

    }

}


@Composable
fun AppComposeHome(navController: NavController) {
    Column() {


        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.EditText.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }


        }) {
            Text("XML no Compose")

        }
        Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
            navController.navigate(AppComposeScreen.TextHome.route) {
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            }


        }) {
            Text("TextView Home")

        }

    }
}