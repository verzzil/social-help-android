package ru.itis.socialhelp.data.db.models

data class TimeTableDb(
    val id: Long,
    val specialistName: String,
    val time: Long,
    val description: String
)
