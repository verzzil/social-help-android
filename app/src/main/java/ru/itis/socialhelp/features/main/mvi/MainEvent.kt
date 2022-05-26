package ru.itis.socialhelp.features.main.mvi

sealed class MainEvent {
    object Leave : MainEvent()
}