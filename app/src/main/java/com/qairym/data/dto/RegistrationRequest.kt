package com.qairym.data.dto


data class RegistrationRequest(
    val username: String,
    val password: String,
//    val about: String,
//    val createdAt: String,
    val location: Location,
)