package ru.itis.socialhelp.features.specialists

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.itis.socialhelp.data.repositories.SpecialistsRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsEvent
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsViewState
import javax.inject.Inject

@HiltViewModel
class SpecialistsViewModel @Inject constructor(
    private val specialistsRepository: SpecialistsRepository
) : BaseViewModel<SpecialistsViewState, SpecialistsEvent>(
    initialState = SpecialistsViewState()
) {

    override fun obtainEvent(event: SpecialistsEvent) =
        when (event) {
            SpecialistsEvent.Loading -> Unit
            is SpecialistsEvent.SetCategoryId -> {
                viewModelScope.launch {
                    _viewState.value = _viewState.value.copy(isLoading = true)

                    withContext(Dispatchers.IO) {
                        val specialists =
                            specialistsRepository.findSpecialistsByCategoryId(event.id)

                        _viewState.value =
                            _viewState.value.copy(isLoading = false, specialists = specialists)
                    }
                }
                Unit
            }
        }
}
