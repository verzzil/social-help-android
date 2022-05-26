package ru.itis.socialhelp.features.chat.models

data class MessageModel(
    val from: Long,
    val to: Long,
    val name: String,
    val lastName: String,
    val date: Long,
    val msg: String,
) {

    fun isMine(): Boolean = from == 1L
}