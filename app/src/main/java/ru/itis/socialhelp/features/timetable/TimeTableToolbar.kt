package ru.itis.socialhelp.features.timetable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.ui.theme.AppTheme

@Composable
fun TimeTableToolbar() {
    val navController = AppTheme.mainNavController

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
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
            text = "Мое расписание",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}