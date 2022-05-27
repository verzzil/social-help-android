package ru.itis.socialhelp.features.main.mvi

import ru.itis.socialhelp.features.main.models.CategoryItem
import ru.itis.socialhelp.features.main.models.SpecializationItem

data class MainViewState(
    val isProblemsLoading: Boolean = true,
    val isDoctorsLoading: Boolean = true,
    val problems: List<SpecializationItem> = emptyList(),
    val categories: List<CategoryItem> = emptyList(),
)
