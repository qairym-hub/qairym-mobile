package com.qairym.data.dto

data class UserResponse(
    val userId: Int,
    val username: String,
    val about: Any,
    val createdAt: Any,
    val roles: List<Role>,
)