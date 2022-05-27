package ru.itis.socialhelp.features.login.mvi

data class LoginViewState(
    val supState: LoginSubState = LoginSubState.SignIn,
    val loginValue: String = "",
    val passValue: String = ""
)

enum class LoginSubState {
    SignIn, SignUp, Forgot
}
