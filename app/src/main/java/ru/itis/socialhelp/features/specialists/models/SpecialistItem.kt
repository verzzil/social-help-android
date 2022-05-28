package ru.itis.socialhelp.features.specialists.models

data class SpecialistItem(
    val id: Long = 0,
    val name: String = "Timur",
    val lastName: String = "Batrshin",
    val patronymic: String = "Albertovich",
    val image: String = "",
    val age: Int = 40,
    val experience: Int = 5,
) {
    val fullName = "$name $lastName $patronymic"
}

val testSpecialist = SpecialistItem()
val testSpecialist2 = SpecialistItem(
    2,"Lexa", "Kucheryavi", "Dmitrievich", "",24, 2
)

val testSpecialistList = listOf(testSpecialist,testSpecialist2)
