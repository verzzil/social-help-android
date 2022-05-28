package ru.itis.socialhelp.data.network.responses

data class GetCurrentUserResponse(
    val accessToken: String,
    val additionalInfoForSpecialist: AdditionalInfoForSpecialist,
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

data class AdditionalInfoForSpecialist(
    val confirmedOnPlatform: Boolean,
    val education: String,
    val experience: Int,
    val `file`: Any,
    val id: Int,
    val photoDocuments: Any,
    val qualification: String,
    val qualification_improvement: String,
    val user: User
)

data class User(
    val active: Boolean,
    val avatarUrl: Any,
    val birthday: String,
    val bloodType: String,
    val city: String,
    val email: String,
    val emailConfirmed: Boolean,
    val `file`: Any,
    val firstName: String,
    val gender: String,
    val hashPassword: String,
    val id: Int,
    val lastName: String,
    val patronymic: String,
    val rate: Double,
    val role: String,
    val specialist: Boolean,
    val state: String,
    val timeTables_specialist: List<TimeTablesSpecialist>,
    val timeTables_user: List<Any>,
    val token: Token
)

data class TimeTablesSpecialist(
    val description: String,
    val id: Int,
    val timeStamp: Long
)

data class Token(
    val accessToken: String,
    val create_time: String,
    val id: Int,
    val refreshToken: String
)