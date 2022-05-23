package com.qairym.data.repository

import android.util.Log
import com.qairym.data.dto.Author
import com.qairym.data.dto.Post
import com.qairym.data.dto.Role
import com.qairym.data.remote.PostApi
import retrofit2.HttpException

class PostRepositoryImpl(
    private val api: PostApi,
) : PostRepository {

    private val remoteDataSource = (1..100).map {
        Post(
            postId = it,
            title = it.toString(),
            text = it.toString(),
            createdAt = it.toString(),
            author = Author(
                userId = it,
                username = it.toString(),
                about = it.toString(),
                createdAt = it.toString(),
                roles = listOf(
                    Role(
                        id = it,
                        name = it.toString()
                    )
                )
            )
        )
    }

    override suspend fun getPosts(pageNumber: Int, pageSize: Int): Result<List<Post>> {
//        delay(2000L)
//        val startingIndex = pageNumber * pageSize
//        return if (startingIndex + pageSize <= remoteDataSource.size) {
//            Result.success(
//                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
//            )
//        } else Result.success(emptyList())
        return try {
            Result.success(
                api.getPosts(pageNumber, pageSize)
            )
        } catch (e: HttpException) {
            Log.e("Getting posts error", e.message())
            Result.success(emptyList())
        } catch (e: Exception) {
            Result.success(emptyList())
        }
    }
}