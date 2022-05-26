package ru.itis.socialhelp.features.main.models

data class SpecializationItem(
    val id: Long,
    val title: String,
    val problem: String,
    val image: String
)

val testSpecialization: SpecializationItem = SpecializationItem(0, "Lor", "throat pain", "")
val testSpecialization2: SpecializationItem =
    SpecializationItem(1, "Dentist", "dental problems", "")
val testSpecialization3: SpecializationItem = SpecializationItem(2, "Dentist", "break bones", "")
val testSpecialization4: SpecializationItem = SpecializationItem(3, "Dentist", "burn", "")
val testSpecialization5: SpecializationItem =
    SpecializationItem(4, "Dentist", "rash on the skin", "")
val testSpecialization6: SpecializationItem = SpecializationItem(5, "Dentist", "warts", "")
val testSpecialization7: SpecializationItem = SpecializationItem(6, "Dentist", "schwarzenegger", "")

val testSpecializationList = listOf(
    testSpecialization,
    testSpecialization2,
    testSpecialization3,
    testSpecialization4,
    testSpecialization5,
    testSpecialization6,
    testSpecialization7
)
