package ru.itis.socialhelp.data.repositories.impl

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import ru.itis.socialhelp.data.repositories.DataStorePreferencesRepository
import ru.itis.socialhelp.features.common.models.User
import javax.inject.Inject
import javax.inject.Singleton

private const val USER_PREFERENCES_NAME = "user_preferences"
private val USER_ID = longPreferencesKey("user_id")
private val USER_NAME = stringPreferencesKey("user_name")
private val USER_LAST_NAME = stringPreferencesKey("user_last_name")
private val USER_PATRONYMIC = stringPreferencesKey("user_patronymic")
private val USER_IMAGE = stringPreferencesKey("user_image")

private val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

@Singleton
class DataStorePreferencesRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context
): DataStorePreferencesRepository {

    private val dataStore = context.dataStore

    override val userPreferencesFlow: Flow<User?> = dataStore.data
        .map { preferences ->
            mapUserPreferences(preferences)
        }
        .catch { exception ->
            exception.printStackTrace()
        }

    override suspend fun setCurrentUser(user: User) {
        dataStore.edit { preferences ->
            preferences[USER_ID] = user.id
            preferences[USER_NAME] = user.name
            preferences[USER_LAST_NAME] = user.lastName
            preferences[USER_PATRONYMIC] = user.patronymic
            preferences[USER_IMAGE] = user.image
        }
    }

    override suspend fun removeCurrentUser() {
        dataStore.edit {
            it.clear()
        }
    }

    private fun mapUserPreferences(preferences: Preferences): User? =
        preferences[USER_ID]?.let {
            User(
                id = it,
                name = preferences[USER_NAME] ?: "",
                lastName = preferences[USER_LAST_NAME] ?: "",
                patronymic = preferences[USER_PATRONYMIC] ?: "",
                image = preferences[USER_IMAGE] ?: ""
            )
        }
}
