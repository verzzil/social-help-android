package ru.itis.socialhelp.features.profile

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.profile.mvi.ProfileEvent
import ru.itis.socialhelp.features.profile.mvi.ProfileViewState
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): BaseViewModel<ProfileViewState, ProfileEvent>(
    initialState = ProfileViewState()
) {

    override fun obtainEvent(event: ProfileEvent) {
        when (event) {

            else -> {}
        }
    }
}