package ru.itis.socialhelp.data.network

import ru.itis.socialhelp.data.network.responses.CategoryResponse

interface SocialHelpApi {

    suspend fun findAllCategories(): List<CategoryResponse>
    suspend fun searchCategoryByName(query: String): List<CategoryResponse>
}