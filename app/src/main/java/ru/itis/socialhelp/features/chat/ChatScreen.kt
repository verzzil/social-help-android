package ru.itis.socialhelp.features.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ru.itis.socialhelp.features.chat.mvi.ChatEvent
import ru.itis.socialhelp.features.chat.views.InputMessageField
import ru.itis.socialhelp.features.chat.views.UserMessage

@Composable
fun ChatScreen(
    viewModel: ChatViewModel
) {
    val viewState by viewModel.viewState.collectAsState()

    val inputMsg = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            reverseLayout = true,
        ) {
            items(viewState.messagesList) {
                UserMessage(msgModel = it)
            }
        }

        InputMessageField(
            inputMsg = inputMsg.value,
            onInputChange = {
                inputMsg.value = it
            },
            onSend = {
                viewModel.obtainEvent(ChatEvent.SendMessage(inputMsg.value))
                inputMsg.value = ""
            }
        )
    }
}
