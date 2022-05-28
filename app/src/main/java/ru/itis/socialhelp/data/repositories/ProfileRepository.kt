package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.common.models.User

interface ProfileRepository {

    suspend fun loadProfile(id: Long) : User
    suspend fun createTimeTable(date: Long, descr: String, accessToken: String, to: Long)
}