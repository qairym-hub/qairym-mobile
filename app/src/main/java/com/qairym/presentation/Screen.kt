package com.qairym.presentation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object RegistrationScreen: Screen("registration_screen")
}