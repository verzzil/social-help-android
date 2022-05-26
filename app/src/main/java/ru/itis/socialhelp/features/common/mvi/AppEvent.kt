package ru.itis.socialhelp.features.common.mvi

sealed class AppEvent {
    object NeedOpenDrawer : AppEvent()
    object ReadyDrawerOpen: AppEvent()
    object NeedCloseDrawer : AppEvent()
    object ReadyDrawerClose: AppEvent()

    data class ChangeScreen(val route: String) : AppEvent()
}