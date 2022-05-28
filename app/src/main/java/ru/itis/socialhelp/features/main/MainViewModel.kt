package ru.itis.socialhelp.features.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.data.repositories.ProblemsRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.main.mvi.MainEvent
import ru.itis.socialhelp.features.main.mvi.MainViewState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val specializationsRepository: SpecializationsRepository,
    private val problemsRepository: ProblemsRepository,
) : BaseViewModel<MainViewState, MainEvent>(
    initialState = MainViewState()
) {

    init {
        viewModelScope.launch {
            _viewState.value =
                _viewState.value.copy(isProblemsLoading = true, isDoctorsLoading = true)

            launch(Dispatchers.IO) {
                val temp = specializationsRepository.findAllSpecializations()
                _viewState.value = _viewState.value.copy(
                    isDoctorsLoading = false,
                    categories = temp
                )
            }

            launch(Dispatchers.IO) {
                val problems = problemsRepository.findAllProblems()

                _viewState.value = _viewState.value.copy(
                    isProblemsLoading = false,
                    problems = problems
                )
            }
        }
    }

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            MainEvent.Leave -> {
                viewModelScope.cancel()
            }
        }
    }
}
