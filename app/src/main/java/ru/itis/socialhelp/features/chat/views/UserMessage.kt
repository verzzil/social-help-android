package ru.itis.socialhelp.features.chat.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import ru.itis.socialhelp.features.chat.models.MessageModel
import ru.itis.socialhelp.ui.theme.LocalColorProvider

@Composable
fun UserMessage(msgModel: MessageModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = when (msgModel.isMine()) {
            true -> Arrangement.End
            else -> Arrangement.Start
        }
    ) {
        if (msgModel.isMine())
            Spacer(modifier = Modifier.weight(.5f))

        Card(
            modifier = Modifier
                .weight(.45f, false),
            shape = cardShapeFor(message = msgModel),
            backgroundColor = when (msgModel.isMine()) {
                true ->
                    LocalColorProvider.current.mineMessageBackground
                else -> LocalColorProvider.current.friendMessageBackground
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = msgModel.msg,
                color = when (msgModel.isMine()) {
                    true ->
                        LocalColorProvider.current.mineMessageTextColor
                    else -> LocalColorProvider.current.friendMessageTextColor
                }
            )
        }

        if (!msgModel.isMine())
            Spacer(modifier = Modifier.weight(.5f))
    }
}

@Composable
fun cardShapeFor(message: MessageModel): Shape {
    val roundedCorners = RoundedCornerShape(16.dp)
    return when {
        message.isMine() -> roundedCorners.copy(bottomEnd = CornerSize(0))
        else -> roundedCorners.copy(bottomStart = CornerSize(0))
    }
}
