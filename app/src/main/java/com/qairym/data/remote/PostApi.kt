package com.qairym.data.remote

import com.qairym.data.dto.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("api/post/find")
    suspend fun getPosts(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

}