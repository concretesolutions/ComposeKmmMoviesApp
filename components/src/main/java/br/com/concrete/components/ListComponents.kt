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
import br.com.concrete.components.devexperience.xml.ExampleFragment
import br.com.concrete.components.devexperience.xml.XmlCompose

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
               // context.startActivity(Intent(context, ExampleFragment()::class.java))

                //XmlCompose()

            }
            composable(AppComposeScreen.XmlCompose.route) {
                //XmlHome(navController)
                // context.startActivity(Intent(context, ExampleFragment()::class.java))

                XmlCompose()

            }
            composable(AppComposeScreen.XmlComposeActivity.route) {
                //XmlHome(navController)
                context.startActivity(Intent(context, ExampleFragment()::class.java))

                //XmlCompose()

            }
        }
    }
}
@Composable
fun XmlHome(navController: NavController){
    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeScreen.XmlCompose.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("XML no Compose")

    }
    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeScreen.XmlComposeActivity.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("XML")

    }


}

@Composable
fun AppComposeHome(navController: NavController) {

    Button(modifier = Modifier.padding(top = 64.dp, start = 124.dp), onClick = {
        navController.navigate(AppComposeScreen.XmlHome.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }


    }) {
        Text("Comparações")

    }
}