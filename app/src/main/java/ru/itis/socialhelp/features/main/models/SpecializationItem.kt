package ru.itis.socialhelp.features.main.models

data class SpecializationItem(
    val id: Long,
    val title: String,
)

val testSpecialist = SpecializationItem(0, "Педиатрия")
val testSpecialist1 = SpecializationItem(0, "Венерология")
val testSpecialist2 = SpecializationItem(0, "Ортопед")
val testSpecialist3 = SpecializationItem(0, "Терапевт")
val testSpecialist4 = SpecializationItem(0, "Гинеколог")
val testSpecialist5 = SpecializationItem(0, "Дерматолог")
val testSpecialist6 = SpecializationItem(0, "Психолог")
val testSpecialist7 = SpecializationItem(0, "Косметолог")
val testSpecialist8 = SpecializationItem(0, "Невролог")
val testSpecialist9 = SpecializationItem(0, "ЛОР")
val testSpecialist10 = SpecializationItem(0, "Офтальмолог")

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
