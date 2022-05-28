package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.network.requests.TimeTableRequest
import ru.itis.socialhelp.data.repositories.ProfileRepository
import ru.itis.socialhelp.features.common.models.User
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : ProfileRepository {

    override suspend fun loadProfile(id: Long): User =
        socialHelpApi.getUserProfile(id).run {
            User(
                id = id,
                name = firstName,
                lastName = lastName,
                patronymic = patronymic,
                image = avatarUrl ?: "",
                isSpecialist = specialist,
            )
        }

    override suspend fun createTimeTable(date: Long, descr: String, accessToken: String, to: Long) {
        socialHelpApi.createTimeTable(
            accessToken,
            to,
            TimeTableRequest(date, descr)
        )
    }
}