package com.qairym.presentation.home.bottomnavbar

import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.qairym.presentation.home.HomeScreen
import com.qairym.presentation.home.ProfileScreen

@ExperimentalPagingApi
@Composable
fun BottomNavGraph(navController: NavHostController, packageManager: PackageManager) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(packageManager = packageManager)
        }
    }
}