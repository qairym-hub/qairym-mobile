package com.qairym.data.repository

import com.qairym.data.dto.Post

interface PostRepository {
    suspend fun getPosts(pageNumber: Int, pageSize: Int): Result<List<Post>>
}