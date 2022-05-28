package ru.itis.socialhelp.features.timetable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.data.network.responses.TimeTableResponse
import ru.itis.socialhelp.features.timetable.mvi.TimeTableEvent
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.colors
import java.text.SimpleDateFormat

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TimeTableScreen(
    viewModel: TimeTableViewModel
) {
    val viewState by viewModel.viewState.collectAsState()
    val appViewState by appViewModel.viewState.collectAsState()
    viewModel.obtainEvent(TimeTableEvent.LoadTimeTables(appViewState.currentUser?.accessToken ?: ""))

    Scaffold(
        topBar = {
            TimeTableToolbar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(viewState.timeTables) {
                TimeTableView(it)
            }
        }
    }
}

@Composable
fun TimeTableView(
    timeTableResponse: TimeTableResponse
) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(200.dp),
        backgroundColor = colors.mainColor
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "У ${timeTableResponse.firstNameUser} ${timeTableResponse.lastNameUser} встреча с ${timeTableResponse.firstNameSpec} ${timeTableResponse.lastNameSpec}",
                style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Bold),
            )
            Text(
                text = SimpleDateFormat("yyyy MMMM d в H:m").format(timeTableResponse.timeStamp),
                style = TextStyle(color = Color.Gray),
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            Divider()
            Text(text = "Описание: ${timeTableResponse.description}", fontWeight = FontWeight.Bold)
        }
    }
}