package com.qairym.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qairym.presentation.home.MainScreen
import com.qairym.presentation.login.LoginScreen
import com.qairym.presentation.registration.RegistrationScreen
import com.qairym.presentation.ui.theme.QairymMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QairymMobileTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}