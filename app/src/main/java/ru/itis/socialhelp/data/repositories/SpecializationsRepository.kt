package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.SpecializationItem
import kotlinx.coroutines.flow.Flow

interface SpecializationsRepository {

    fun findAllProblems(): Flow<List<SpecializationItem>>
}