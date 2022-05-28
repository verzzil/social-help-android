package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.network.requests.LoginRequest
import ru.itis.socialhelp.data.network.responses.GetCurrentUserResponse
import ru.itis.socialhelp.data.network.responses.LoginResponse
import ru.itis.socialhelp.data.repositories.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : LoginRepository {

    override suspend fun login(login: String, pass: String): LoginResponse =
        socialHelpApi.login(
            LoginRequest(login, pass)
        )

    override suspend fun getCurrentUser(accessToken: String): GetCurrentUserResponse =
        socialHelpApi.getCurrentUser(accessToken)
}