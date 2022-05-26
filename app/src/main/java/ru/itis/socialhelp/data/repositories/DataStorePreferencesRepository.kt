package ru.itis.socialhelp.data.repositories

import kotlinx.coroutines.flow.Flow
import ru.itis.socialhelp.features.common.models.User

interface DataStorePreferencesRepository {

    val userPreferencesFlow: Flow<User?>

    suspend fun setCurrentUser(user: User)
    suspend fun removeCurrentUser()
}