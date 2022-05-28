package ru.itis.socialhelp.features.timetable.mvi

import ru.itis.socialhelp.data.network.responses.TimeTableResponse

data class TimeTableViewState(
    val isLoading: Boolean = false,
    val timeTables: List<TimeTableResponse> = emptyList()
)