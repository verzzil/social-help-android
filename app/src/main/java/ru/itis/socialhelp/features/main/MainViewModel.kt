package ru.itis.socialhelp.features.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.CategoriesRepository
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.main.mvi.MainEvent
import ru.itis.socialhelp.features.main.mvi.MainViewState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val specializationsRepository: SpecializationsRepository,
) : BaseViewModel<MainViewState, MainEvent>(
    initialState = MainViewState()
) {

    init {
        viewModelScope.launch {
            _viewState.value =
                _viewState.value.copy(isProblemsLoading = true, isDoctorsLoading = true)

            launch(Dispatchers.IO) {
                delay(3000)
                val temp = categoriesRepository.findAllCategories()
                _viewState.value = _viewState.value.copy(
                    isDoctorsLoading = false,
                    categories = temp
                )
            }

            launch(Dispatchers.IO) {
                specializationsRepository.findAllProblems()
                    .collect {
                        _viewState.value = _viewState.value.copy(
                            isProblemsLoading = false,
                            problems = it
                        )
                    }
            }
        }.invokeOnCompletion {
//            Log.i("asdfasdf", "quit")
        }
    }

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            MainEvent.Leave -> {
                viewModelScope.cancel()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("asdfasdf", "main viewmodel has cleared")
    }
}