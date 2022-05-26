package ru.itis.socialhelp.features.chat.mvi

import ru.itis.socialhelp.features.chat.models.MessageModel

data class ChatViewState(
    val toolbarTitle: String = "Albert Khannanov",
    val messagesList: List<MessageModel> = listOf(
        MessageModel(2,1, "", "", 2, "hello"),
        MessageModel(1,1, "", "", 1, "hello"),
    ),
    val friendName: String = "Тимур Батршин"
)