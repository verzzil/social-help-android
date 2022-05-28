package ru.itis.socialhelp.features.main.models

data class ProblemItem(
    val id: Long,
    val image: String,
    val problem: String
)

val testSpecialization: ProblemItem = ProblemItem(0, "Lor", "throat pain")
val testSpecialization2: ProblemItem =
    ProblemItem(1, "Dentist", "dental problems")
val testSpecialization3: ProblemItem = ProblemItem(2, "Dentist", "break bones")
val testSpecialization4: ProblemItem = ProblemItem(3, "Dentist", "burn")
val testSpecialization5: ProblemItem =
    ProblemItem(4, "Dentist", "rash on the skin")
val testSpecialization6: ProblemItem = ProblemItem(5, "Dentist", "warts")
val testSpecialization7: ProblemItem = ProblemItem(6, "Dentist", "schwarzenegger")

val testSpecializationList = listOf(
    testSpecialization,
    testSpecialization2,
    testSpecialization3,
    testSpecialization4,
    testSpecialization5,
    testSpecialization6,
    testSpecialization7
)
