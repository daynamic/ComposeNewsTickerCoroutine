package com.akshat.composenewstickercoroutine.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshat.composenewstickercoroutine.screens.HomeScreenViewModel
import com.akshat.composenewstickercoroutine.screens.NewsTickerHomeScreen

@Composable
fun NewsTickerNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NewsTickerScreen.NewsTickerHomeScreen.name ){

        composable(NewsTickerScreen.NewsTickerHomeScreen.name) {
            val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
            NewsTickerHomeScreen(navController = navController, viewModel = homeScreenViewModel)
        }
    }

}