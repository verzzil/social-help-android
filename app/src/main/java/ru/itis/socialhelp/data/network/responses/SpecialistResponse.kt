package ru.itis.socialhelp.data.network.responses

data class SpecialistResponse(
    val avatarUrl: String,
    val city: String,
    val firstName: String,
    val id: Long,
    val lastName: String,
    val rate: Double,
    val specialization: String,
    val experience: Int
)