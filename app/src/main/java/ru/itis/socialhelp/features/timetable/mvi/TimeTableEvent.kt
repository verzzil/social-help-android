package ru.itis.socialhelp.features.timetable.mvi

sealed class TimeTableEvent {
    data class LoadTimeTables(val accessToken: String) : TimeTableEvent()
}