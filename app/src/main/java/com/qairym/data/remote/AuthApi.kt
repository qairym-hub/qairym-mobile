package com.qairym.data.remote

import com.qairym.data.dto.LoginRequest
import com.qairym.data.dto.RegistrationRequest
import com.qairym.data.dto.TokenResponse
import retrofit2.http.*

interface AuthApi {

    @POST("api/user/save")
    suspend fun signUp(
        @Body request: RegistrationRequest,
    )

    @POST("login")
    suspend fun signIn(
        @Body request: LoginRequest,
    ): TokenResponse

    @GET("api/user/find/username/{username}")
    suspend fun getUser(
        @Header("Authorization") token: String,
        @Path("username") username: String
    )
}