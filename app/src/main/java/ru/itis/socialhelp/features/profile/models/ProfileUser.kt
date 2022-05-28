package ru.itis.socialhelp.features.profile.models

data class ProfileUser(
    val id: Long = 0,
    val name: String = "Albert",
    val lastName: String = "Khanannov",
    val patronymic: String = "Ildarovich",
    val image: String = "",
    val isSpecialist: Boolean = false,
)
