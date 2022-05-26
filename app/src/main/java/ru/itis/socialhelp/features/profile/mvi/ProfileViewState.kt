package ru.itis.socialhelp.features.profile.mvi

import ru.itis.socialhelp.features.common.models.User
import ru.itis.socialhelp.features.common.models.testUser

data class ProfileViewState(
    val user: User = testUser
)
