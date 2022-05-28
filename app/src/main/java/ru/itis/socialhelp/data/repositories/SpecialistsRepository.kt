package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.SpecializationItem
import kotlinx.coroutines.flow.Flow
import ru.itis.socialhelp.features.specialists.models.SpecialistItem

interface SpecialistsRepository {

    fun findMySpecialists(userId: Long) : Flow<List<SpecializationItem>>
    suspend fun findAllSpecialists(): List<SpecializationItem>

    suspend fun findSpecialistsByCategoryId(id: Long) : List<SpecialistItem>
}