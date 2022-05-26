package ru.itis.socialhelp.features.common.mvi

import ru.itis.socialhelp.features.common.models.User
import ru.itis.socialhelp.features.common.models.testUser

data class AppViewState(
    val needOpenDrawer: Boolean = false,
    val needCloseDrawer: Boolean = false,
    val currentUser: User? = testUser
)