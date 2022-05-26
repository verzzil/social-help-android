package ru.itis.socialhelp.features.chat.mvi

import ru.itis.socialhelp.features.chat.models.MessageModel

sealed class ChatEvent {
    data class SendMessage(val msg: String) : ChatEvent()

    data class ReceiveMessage(val msg: MessageModel) : ChatEvent()

    data class LoadCorrespondence(val messages: List<MessageModel>) : ChatEvent()
}