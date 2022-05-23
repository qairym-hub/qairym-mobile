package com.qairym.presentation.home.utils

import com.qairym.data.dto.Post

data class PostScreenState(
    val isLoading: Boolean = false,
    val items: List<Post> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)