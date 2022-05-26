package ru.itis.socialhelp.features.chat

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.chat.models.MessageModel
import ru.itis.socialhelp.features.chat.mvi.ChatEvent
import ru.itis.socialhelp.features.chat.mvi.ChatViewState
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor() : BaseViewModel<ChatViewState, ChatEvent>(
    initialState = ChatViewState()
) {

    private var isMine = true;
    private var date = 3L;

    override fun obtainEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.LoadCorrespondence -> {
                _viewState.value = _viewState.value.copy(
                    messagesList = event.messages
                )
            }
            is ChatEvent.ReceiveMessage -> {
                var newList = _viewState.value.messagesList + event.msg
                newList = newList.sortedBy { it.date }.asReversed()

                _viewState.value = _viewState.value.copy(
                    messagesList = newList
                )
            }
            is ChatEvent.SendMessage -> {
                var newList = _viewState.value.messagesList + MessageModel(
                    from = if (isMine) 1 else 0,
                    to = 1,
                    name = "Alba",
                    lastName = "Khan",
                    date = date++,
                    msg = event.msg
                )
                newList = newList.sortedBy { it.date }.asReversed()
                isMine = !isMine

                _viewState.value = _viewState.value.copy(
                    messagesList = newList
                )
            }
        }
    }
}
