package ru.itis.socialhelp.features.categories

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.features.base.BaseViewModel
import ru.itis.socialhelp.features.categories.mvi.CategoriesEvent
import ru.itis.socialhelp.features.categories.mvi.CategoriesViewState
import ru.itis.socialhelp.features.main.models.SpecializationItem
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val specializationsRepository: SpecializationsRepository,
) : BaseViewModel<CategoriesViewState, CategoriesEvent>(
    initialState = CategoriesViewState()
) {

    private var cashedCategories: List<SpecializationItem> = emptyList()

    init {
        viewModelScope.launch {
            _viewState.value = _viewState.value.copy(isLoading = true)

            val categories = specializationsRepository.findAllSpecializations()

            cashedCategories = categories
            _viewState.value = _viewState.value.copy(isLoading = false, categories = categories)
        }
    }

    override fun obtainEvent(event: CategoriesEvent) =
        when (event) {
            CategoriesEvent.LoadCategories -> Unit
            CategoriesEvent.ToggleSearchMode -> {
                _viewState.value.isSearching.let {
                    _viewState.value = _viewState.value.copy(
                        isSearching = !it,
                    )
                }
            }
            is CategoriesEvent.SearchInputChange ->
                cashedCategories.filter { it.title.startsWith(event.query, true) }.let {
                    _viewState.value =
                        _viewState.value.copy(searchInput = event.query, categories = it)
                }
            CategoriesEvent.ClearSearchInput ->
                _viewState.value = _viewState.value.copy(searchInput = "", categories = cashedCategories)
        }
}