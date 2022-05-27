package ru.itis.socialhelp.features.categories.mvi

sealed class CategoriesEvent {
    object LoadCategories : CategoriesEvent()
    object ToggleSearchMode : CategoriesEvent()
    object ClearSearchInput : CategoriesEvent()

    data class SearchInputChange(val query: String) : CategoriesEvent()
}