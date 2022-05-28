package ru.itis.socialhelp.features.profile

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.ProfileRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.profile.mvi.ProfileEvent
import ru.itis.socialhelp.features.profile.mvi.ProfileViewState
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
): BaseViewModel<ProfileViewState, ProfileEvent>(
    initialState = ProfileViewState()
) {

    override fun obtainEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.LoadProfile -> {
                viewModelScope.launch {
                    profileRepository.loadProfile(event.id).apply {
                        _viewState.value = _viewState.value.copy(user = this)
                    }
                }
            }
            is ProfileEvent.CreateTimeTable -> {
                viewModelScope.launch {
                    profileRepository.createTimeTable(event.date, event.descr, event.accessToken, event.toUser)
                }
            }
        }
    }
}