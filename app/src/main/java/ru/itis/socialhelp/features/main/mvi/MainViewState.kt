package ru.itis.socialhelp.features.main.mvi

import ru.itis.socialhelp.features.main.models.CategoryItem
import ru.itis.socialhelp.features.main.models.SpecializationItem

data class MainViewState(
    val isProblemsLoading: Boolean = true,
    val isDoctorsLoading: Boolean = true,
    val problems: List<SpecializationItem> = emptyList(),
    val mySpecialists: List<CategoryItem> = emptyList(),
    val specialists: List<CategoryItem> = emptyList(),
)
