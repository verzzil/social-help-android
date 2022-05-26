package ru.itis.socialhelp.features.main.models

data class CategoryItem(
    val id: Long,
    val title: String,
    val description: String,
    val image: String
)

val testSpecialist = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist1 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist2 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist3 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist4 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist5 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist6 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist7 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist8 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist9 = CategoryItem(0, "Педиатрия", "some description", "")
val testSpecialist10 = CategoryItem(0, "Педиатрия", "some description", "")

val testCategoryList = listOf(
    testSpecialist,
    testSpecialist1,
    testSpecialist2,
    testSpecialist3,
    testSpecialist4,
    testSpecialist5,
    testSpecialist6,
    testSpecialist7,
    testSpecialist8,
    testSpecialist9,
    testSpecialist10,
)
