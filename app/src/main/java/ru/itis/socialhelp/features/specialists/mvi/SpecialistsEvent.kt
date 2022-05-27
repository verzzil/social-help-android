package ru.itis.socialhelp.features.specialists.mvi

sealed class SpecialistsEvent {
    object Loading : SpecialistsEvent()

    data class SetCategoryId(val id: Long) : SpecialistsEvent()
}
