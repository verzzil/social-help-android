package ru.itis.socialhelp.features.login.mvi

sealed class LoginEvent {
    data class InputLoginField(val login: String) : LoginEvent()
    data class InputPassField(val pass: String) : LoginEvent()
}