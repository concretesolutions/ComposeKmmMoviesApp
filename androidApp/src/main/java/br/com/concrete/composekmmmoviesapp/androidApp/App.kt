package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import br.com.concrete.composekmmmoviesapp.androidApp.model.Screen
import br.com.concrete.composekmmmoviesapp.androidApp.model.bottomBarItems
import br.com.concrete.composekmmmoviesapp.androidApp.theme.ComposeMoviesAppTheme
import br.com.concrete.composekmmmoviesapp.androidApp.theme.Yellow

@Preview(device = Devices.PIXEL_4_XL)
@Composable
fun MoviAddesApp() {
    val navController = rememberNavController()
    ComposeMoviesAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
            },
            bottomBar = { MoviesAppBottomBar(navController) }
        ) {
            NavHost(navController, startDestination = Screen.Movies.route) {
                composable(Screen.Movies.route) {
                    Button(onClick = {
                        navController.navigate(Screen.Detail.route)
                    }) {
                        Text("Go to detail")
                    }
                }
                composable(Screen.Favorites.route) { Text("Favorites") }
                composable(Screen.Detail.route) {
                    Box(
                        modifier = Modifier
                            .background(Yellow)
                            .fillMaxSize()
                    ) {
                        Text("Detail")
                    }
                }
            }
        }
    }
}

@Composable
fun MoviesAppBottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    BottomNavigation {
        bottomBarItems.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        stringResource(id = screen.titleRes)
                    )
                },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                },
                label = { Text(stringResource(screen.titleRes)) }
            )
        }
    }
}