package com.qairym.data.repository

import com.qairym.data.dto.Location
import com.qairym.data.utils.AuthResult


interface AuthRepository {
    suspend fun signUp(username: String, password: String, location: Location): AuthResult<Unit>
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
}