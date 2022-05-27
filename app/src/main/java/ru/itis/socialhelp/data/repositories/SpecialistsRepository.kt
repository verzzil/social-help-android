package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.CategoryItem
import kotlinx.coroutines.flow.Flow
import ru.itis.socialhelp.features.specialists.models.SpecialistItem

interface SpecialistsRepository {

    fun findMySpecialists(userId: Long) : Flow<List<CategoryItem>>
    suspend fun findAllSpecialists(): List<CategoryItem>

    suspend fun findSpecialistsByCategoryId(id: Long) : List<SpecialistItem>
}