package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.data.network.responses.GetCurrentUserResponse
import ru.itis.socialhelp.data.network.responses.LoginResponse

interface LoginRepository {

    suspend fun login(login: String, pass: String) : LoginResponse
    suspend fun getCurrentUser(accessToken: String): GetCurrentUserResponse
}