package com.qairym.presentation.auth.utils

data class AuthState(
    val isLoading: Boolean = false,
    val signUpEmail: String = "",
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signInUsername: String = "",
    val signInPassword: String = ""
)