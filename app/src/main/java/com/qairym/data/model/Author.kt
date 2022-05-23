package com.qairym.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val userId: Int,
    val username: String,
    val about: String,
//    @Embedded
//    @Ignore
//    val roles: List<Role>,
)

