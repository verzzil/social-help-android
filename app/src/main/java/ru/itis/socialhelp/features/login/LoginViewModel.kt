package ru.itis.socialhelp.features.login

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.login.mvi.LoginEvent
import ru.itis.socialhelp.features.login.mvi.LoginViewState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel<LoginViewState, LoginEvent>(
    initialState = LoginViewState()
) {

    override fun obtainEvent(event: LoginEvent) =
        when (event) {
            is LoginEvent.InputLoginField ->
                _viewState.value = _viewState.value.copy(loginValue = event.login)
            is LoginEvent.InputPassField ->
                _viewState.value = _viewState.value.copy(passValue = event.pass)
        }
}