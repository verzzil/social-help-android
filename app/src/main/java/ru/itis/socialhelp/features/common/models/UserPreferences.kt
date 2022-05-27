package ru.itis.socialhelp.features.common.models

data class User(
    val id: Long = 0,
    val name: String = "Albert",
    val lastName: String = "Khanannov",
    val patronymic: String = "Ildarovich",
    val image: String = "",
    val isSpecialist: Boolean = false
) {
    val fullName = "$name $lastName"
}

val testUser = User()
val testUser2 = User(
    id = 1000,
    name = "Dalechka",
    lastName = "Kanipova",
    patronymic = "Vadimovna",
    image = "",
    isSpecialist = true
)
