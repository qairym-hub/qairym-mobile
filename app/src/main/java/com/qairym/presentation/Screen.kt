package com.qairym.presentation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object RegistrationScreen: Screen("registration_screen")
    object HomeScreen: Screen("home_screen")
    object ProfileScreen: Screen("profile_screen")
}