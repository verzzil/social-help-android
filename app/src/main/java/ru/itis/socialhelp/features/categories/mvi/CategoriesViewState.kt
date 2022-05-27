package ru.itis.socialhelp.features.categories.mvi

import ru.itis.socialhelp.features.categories.models.SuggestionItem
import ru.itis.socialhelp.features.main.models.CategoryItem

data class CategoriesViewState(
    val isLoading: Boolean = false,
    val isSearching: Boolean = false,
    val isSuggestionShowing: Boolean = false,
    val searchInput: String = "",
    val categories: List<CategoryItem> = emptyList(),
    val suggestionItems: List<SuggestionItem> = emptyList(),
)