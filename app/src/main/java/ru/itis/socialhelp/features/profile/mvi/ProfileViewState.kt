package ru.itis.socialhelp.features.profile.mvi

import ru.itis.socialhelp.features.common.models.User
import ru.itis.socialhelp.features.common.models.testUser
import ru.itis.socialhelp.features.common.models.testUser2

data class ProfileViewState(
    val user: User = testUser
)
