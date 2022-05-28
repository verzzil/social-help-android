package ru.itis.socialhelp.data.network.responses

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)