package ru.itis.socialhelp.data.network.requests

data class LoginRequest(
    val email: String,
    val hashPassword: String
)