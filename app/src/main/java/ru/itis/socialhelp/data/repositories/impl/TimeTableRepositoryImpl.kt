package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.network.responses.TimeTableResponse
import ru.itis.socialhelp.data.repositories.TimeTableRepository
import javax.inject.Inject

class TimeTableRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : TimeTableRepository {

    override suspend fun getMyTimeTables(accessToken: String): List<TimeTableResponse> =
        socialHelpApi.getMyTimeTables(accessToken)
}