package ru.itis.socialhelp.features.specialists.mvi

import ru.itis.socialhelp.features.specialists.models.SpecialistItem

data class SpecialistsViewState(
    val isLoading: Boolean = false,
    val specializationTitle: String = "",
    val specialists: List<SpecialistItem> = emptyList()
)
