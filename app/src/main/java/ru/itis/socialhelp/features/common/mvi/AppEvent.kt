package ru.itis.socialhelp.features.common.mvi

import ru.itis.socialhelp.features.login.mvi.LoginEvent

sealed class AppEvent {
    object NeedOpenDrawer : AppEvent()
    object ReadyDrawerOpen: AppEvent()
    object NeedCloseDrawer : AppEvent()
    object ReadyDrawerClose: AppEvent()

    data class ChangeScreen(val route: String) : AppEvent()
    data class Login(val login: String, val pass: String) : AppEvent()
}