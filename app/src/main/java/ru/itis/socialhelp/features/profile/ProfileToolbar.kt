package ru.itis.socialhelp.features.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun ProfileToolbar(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel
) {
    val appViewModel = LocalViewModelProvider.current
    val navController = LocalNavControllerProvider.current

    val appViewState by appViewModel.viewState.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
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
            text = stringResource(id = R.string.profile_title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {
                // todo
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_edit_note_24),
                contentDescription = stringResource(id = R.string.cd_open_settings)
            )
        }
    }
}