package ru.itis.socialhelp.features.timetable

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.TimeTableRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.timetable.mvi.TimeTableEvent
import ru.itis.socialhelp.features.timetable.mvi.TimeTableViewState
import javax.inject.Inject

@HiltViewModel
class TimeTableViewModel @Inject constructor(
    private val timeTableRepository: TimeTableRepository
) : BaseViewModel<TimeTableViewState, TimeTableEvent>(
    initialState = TimeTableViewState()
) {

    override fun obtainEvent(event: TimeTableEvent) {
        when (event) {
            is TimeTableEvent.LoadTimeTables -> {
                viewModelScope.launch {
                    _viewState.value = _viewState.value.copy(isLoading = true)

                    val resp = timeTableRepository.getMyTimeTables(event.accessToken)

                    _viewState.value = _viewState.value.copy(
                        isLoading = false,
                        timeTables = resp
                    )
                }
            }
        }
    }
}