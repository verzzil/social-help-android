package ru.itis.socialhelp.features.drawer.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun ColumnScope.DrawerMenuItem(
    title: String,
    onClick: () -> Unit,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    needWeight: Boolean = true
) {
    val appViewModel = appViewModel

    Row(
        modifier = when {
            needWeight ->
                Modifier
                    .fillMaxWidth()
                    .weight(.2f)
                    .clickable(
                        onClick = {
                            onClick()
                            appViewModel.obtainEvent(AppEvent.NeedCloseDrawer)
                        },
                        indication = rememberRipple(bounded = true),
                        interactionSource = MutableInteractionSource()
                    )
                    .padding(horizontal = 12.dp)
            else ->
                Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            onClick()
                            appViewModel.obtainEvent(AppEvent.NeedCloseDrawer)
                        },
                        indication = rememberRipple(bounded = true),
                        interactionSource = MutableInteractionSource()
                    )
                    .padding(horizontal = 12.dp, vertical = 16.dp)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        Text(
            text = title
        )
    }
}
