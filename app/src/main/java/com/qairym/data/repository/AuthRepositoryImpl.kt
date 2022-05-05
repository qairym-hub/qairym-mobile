package com.qairym.data.repository

import android.content.SharedPreferences
import android.util.Log
import com.qairym.data.dto.Location
import com.qairym.data.dto.LoginRequest
import com.qairym.data.dto.RegistrationRequest
import com.qairym.data.remote.AuthApi
import com.qairym.data.utils.AuthResult
import retrofit2.HttpException
import java.lang.Exception

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences,
) : AuthRepository {

    override suspend fun signUp(
        username: String,
        password: String,
        location: Location,
    ): AuthResult<Unit> {
        return try {
            api.signUp(
                request = RegistrationRequest(
                    username = username,
                    password = password,
                    location = Location(3)
                )
            )
            signIn(username, password)
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.signIn(
                request = LoginRequest(
                    username = username,
                    password = password
                )
            )
            prefs.edit()
                .putString("jwt", response.access_token)
                .apply()
            AuthResult.Authorized()
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                Log.e("Error", e.message())
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

}