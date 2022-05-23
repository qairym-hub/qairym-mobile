package com.qairym.data.utils

sealed class AuthResult<T>(val data: T? = null) {
    class Authorized<T>(data: T? = null): AuthResult<T>(data)
    class Unauthorized<T>: AuthResult<T>()
    class UnknownError<T>: AuthResult<T>()
}

sealed class PostsResult<T>(val data: T? = null) {
    class Success<T>(data: T? = null): PostsResult<T>(data)
    class UnknownError<T>: PostsResult<T>()
}