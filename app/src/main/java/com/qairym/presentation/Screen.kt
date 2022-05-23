package com.qairym.presentation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login")
    object RegistrationScreen: Screen("registration")
    object MainScreen: Screen("main")
}