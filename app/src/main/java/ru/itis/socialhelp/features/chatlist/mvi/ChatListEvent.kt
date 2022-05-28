package ru.itis.socialhelp.features.chatlist.mvi

sealed class ChatListEvent {
    data class LoadList(val userId: Long) : ChatListEvent()
}