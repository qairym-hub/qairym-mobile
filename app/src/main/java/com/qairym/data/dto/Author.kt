package com.qairym.data.dto

data class Author(
    val userId: Int,
    val username: String,
    val about: String,
    val createdAt: String,
    val roles: List<Role>
)