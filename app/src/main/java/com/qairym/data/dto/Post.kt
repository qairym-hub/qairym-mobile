package com.qairym.data.dto

data class Post(
    val postId: Int,
    val title: String,
    val text: String,
    val createdAt: String,
    val author: Author
)