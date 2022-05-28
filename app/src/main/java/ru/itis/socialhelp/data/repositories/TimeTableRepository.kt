package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.data.network.responses.TimeTableResponse

interface TimeTableRepository {

    suspend fun getMyTimeTables(accessToken: String) : List<TimeTableResponse>
}