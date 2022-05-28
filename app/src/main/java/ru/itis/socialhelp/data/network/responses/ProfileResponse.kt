package ru.itis.socialhelp.data.network.responses

data class ProfileResponse(
    val accessToken: Any,
    val additionalInfoForSpecialist: Any,
    val avatarUrl: String,
    val birthday: String,
    val bloodType: String,
    val city: String,
    val email: String,
    val emailConfirmed: Boolean,
    val firstName: String,
    val gender: String,
    val hashPassword: Any,
    val id: Long,
    val lastName: String,
    val patronymic: String,
    val rate: Double,
    val role: String,
    val specialist: Boolean,
    val state: String
)