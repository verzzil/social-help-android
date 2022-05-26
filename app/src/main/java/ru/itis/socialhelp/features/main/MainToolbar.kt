package ru.itis.socialhelp.features.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun MainToolbar(
    modifier: Modifier = Modifier,
) {
    val appViewModel = LocalViewModelProvider.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                appViewModel.obtainEvent(AppEvent.NeedOpenDrawer)
            },
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .fillMaxHeight()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = stringResource(id = R.string.open_search_menu)
            )
        }
        Text(
            text = stringResource(id = R.string.main_toolbar_title),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
        )
    }
}