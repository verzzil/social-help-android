package ru.itis.socialhelp.features.chat

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider

@Composable
fun ChatToolbar(
    viewModel: ChatViewModel,
    modifier: Modifier = Modifier,
) {
    val navController = LocalNavControllerProvider.current

    val viewState by viewModel.viewState.collectAsState()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier,
            onClick = {
                navController.navigateUp()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = stringResource(id = R.string.back)
            )
        }

        Text(
            text = viewState.friendName,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}