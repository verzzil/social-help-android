package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.CategoryItem
import kotlinx.coroutines.flow.Flow

interface SpecialistsRepository {

    fun findMySpecialists(userId: Long) : Flow<List<CategoryItem>>
    suspend fun findAllSpecialists(): List<CategoryItem>
}