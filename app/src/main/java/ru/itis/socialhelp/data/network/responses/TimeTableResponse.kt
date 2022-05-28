package ru.itis.socialhelp.data.network.responses

data class TimeTableResponse(
    val description: String = "",
    val firstNameSpec: String= "",
    val firstNameUser: String= "",
    val lastNameSpec: String= "",
    val lastNameUser: String= "",
    val timeStamp: Long =0
)