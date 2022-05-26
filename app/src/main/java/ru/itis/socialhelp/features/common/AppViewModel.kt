package ru.itis.socialhelp.features.common

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.DataStorePreferencesRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.common.models.User
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.features.common.mvi.AppViewState
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val dataStorePreferencesRepository: DataStorePreferencesRepository
) : BaseViewModel<AppViewState, AppEvent>(
    initialState = AppViewState()
) {

    init {
        viewModelScope.launch {
            dataStorePreferencesRepository.userPreferencesFlow
                .collect {
                    _viewState.value = _viewState.value.copy(currentUser = it)
                }
        }
    }

    override fun obtainEvent(event: AppEvent) {
        when (event) {
            AppEvent.NeedOpenDrawer ->
                _viewState.value =
                    _viewState.value.copy(needOpenDrawer = true, needCloseDrawer = false)
            AppEvent.ReadyDrawerOpen ->
                _viewState.value =
                    _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = false)

            AppEvent.NeedCloseDrawer ->
                _viewState.value =
                    _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = true)
            AppEvent.ReadyDrawerClose ->
                _viewState.value =
                    _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = false)
        }
    }
}