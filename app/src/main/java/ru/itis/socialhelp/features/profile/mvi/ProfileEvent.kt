package ru.itis.socialhelp.features.profile.mvi

sealed class ProfileEvent {
    data class LoadProfile(val id: Long) : ProfileEvent()
    data class CreateTimeTable(val date: Long, val descr: String, val accessToken: String, val toUser: Long) : ProfileEvent()
}
