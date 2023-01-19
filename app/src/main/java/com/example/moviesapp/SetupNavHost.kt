package com.example.moviesapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.screens.MainScreen
import com.example.moviesapp.screens.SplashScreen
import com.example.moviesapp.utils.Constants
import com.example.moviesapp.viewmodels.MainViewModel

@Composable
fun SetupNavHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.Detail.route) {

        }
    }
}


sealed class Screen(val route: String) {
    object Splash : Screen(Constants.Screens.SPLASH_SCREEN)
    object Main : Screen(Constants.Screens.MAIN_SCREEN)
    object Detail : Screen(Constants.Screens.DETAILS_SCREEN)
}