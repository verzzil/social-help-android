package ru.itis.socialhelp.data.network

import retrofit2.http.*
import ru.itis.socialhelp.data.network.requests.LoginRequest
import ru.itis.socialhelp.data.network.requests.TimeTableRequest
import ru.itis.socialhelp.data.network.responses.*

interface SocialHelpApi {

//    suspend fun findAllCategories(): List<CategoryResponse>
//    suspend fun searchCategoryByName(query: String): List<CategoryResponse>

    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @GET("/profile")
    suspend fun getCurrentUser(
        @Header("Authorization") authHeader: String
    ): GetCurrentUserResponse

    @GET("/allProblem")
    suspend fun getProblems() : List<ProblemResponse>

    @GET("/AllSpecialization")
    suspend fun getAllSpecializations(): List<SpecializationResponse>

    @GET("/profile/{userId}")
    suspend fun getUserProfile(
        @Path("userId") userId: Long
    ) : ProfileResponse

    @GET("/specialization/{specId}")
    suspend fun getSpecialistsBySpecializationId(
        @Path("specId") specId: Long
    ) : List<SpecialistResponse>

    @POST("/setTimeTable/{toUser}")
    suspend fun createTimeTable(
        @Header("Authorization") authHeader: String,
        @Path("toUser") to: Long,
        @Body timeTableRequest: TimeTableRequest,
    )
}