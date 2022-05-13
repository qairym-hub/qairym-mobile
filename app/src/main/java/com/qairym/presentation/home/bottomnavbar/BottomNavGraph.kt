package com.qairym.presentation.home.bottomnavbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qairym.presentation.home.HomeScreen
import com.qairym.presentation.home.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}