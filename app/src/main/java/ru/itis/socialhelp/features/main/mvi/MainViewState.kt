package ru.itis.socialhelp.features.main.mvi

import ru.itis.socialhelp.features.main.models.SpecializationItem
import ru.itis.socialhelp.features.main.models.ProblemItem

data class MainViewState(
    val isProblemsLoading: Boolean = true,
    val isDoctorsLoading: Boolean = true,
    val problems: List<ProblemItem> = emptyList(),
    val categories: List<SpecializationItem> = emptyList(),
)
