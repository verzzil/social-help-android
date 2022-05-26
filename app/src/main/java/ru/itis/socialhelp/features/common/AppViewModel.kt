package ru.itis.socialhelp.features.common

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.features.common.mvi.AppViewState
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(): BaseViewModel<AppViewState, AppEvent>(
    initialState = AppViewState()
) {
    override fun obtainEvent(event: AppEvent) {
        when (event) {
            AppEvent.NeedOpenDrawer ->
                _viewState.value = _viewState.value.copy(needOpenDrawer = true, needCloseDrawer = false)
            AppEvent.ReadyDrawerOpen ->
                _viewState.value = _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = false)

            AppEvent.NeedCloseDrawer ->
                _viewState.value = _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = true)
            AppEvent.ReadyDrawerClose ->
                _viewState.value = _viewState.value.copy(needOpenDrawer = false, needCloseDrawer = false)
        }
    }
}