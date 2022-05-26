package ru.itis.socialhelp.features.chat.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.itis.socialhelp.R
import ru.itis.socialhelp.ui.theme.LocalColorProvider
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@Composable
fun InputMessageField(
    inputMsg: String,
    onInputChange: (String) -> Unit,
    onSend: (String) -> Unit,
) {

    Divider(
        color = LocalColorProvider.current.inputMessageDividerColor
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        TextField(
            value = inputMsg,
            onValueChange = {
                onInputChange(it)
            },
            placeholder = {
                Text(text = stringResource(id = R.string.chat_placeholder_input_msg))
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LocalColorProvider.current.messageInputColor,
                disabledIndicatorColor = LocalColorProvider.current.messageInputColor,
                errorIndicatorColor = LocalColorProvider.current.messageInputColor,
                focusedIndicatorColor = LocalColorProvider.current.messageInputColor,
                unfocusedIndicatorColor = LocalColorProvider.current.messageInputColor,
                trailingIconColor = LocalColorProvider.current.messageSendIconColor,
                disabledTrailingIconColor = LocalColorProvider.current.disabledMessageSendIconColor,
            ),
            trailingIcon = {
                IconButton(
                    modifier = Modifier.weight(.05f),
                    onClick = {
                        onSend(inputMsg)
                    },
                    enabled = inputMsg.isNotEmpty(),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_send_24),
                        contentDescription = "send msg",
                    )
                }
            },
            modifier = Modifier.weight(.95f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputMessageFieldPreview() {
    SocialHelpTheme {
        InputMessageField(inputMsg = "", onInputChange = {}, onSend = {})
    }
}
