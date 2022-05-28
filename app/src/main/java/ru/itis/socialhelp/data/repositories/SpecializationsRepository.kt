package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.SpecializationItem

interface SpecializationsRepository {

    suspend fun findAllSpecializations(): List<SpecializationItem>
}