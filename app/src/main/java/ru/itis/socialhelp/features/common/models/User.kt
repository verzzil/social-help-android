package ru.itis.socialhelp.features.common.models

data class User(
    val id: Long = 0,
    val name: String = "Albert",
    val lastName: String = "Khanannov",
    val patronymic: String = "",
    val image: String = ""
) {
    val fullName = "$name $lastName"
}

val testUser = User()
