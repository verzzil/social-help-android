package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.features.main.models.SpecializationItem
import javax.inject.Inject

class SpecializationsRepositoryImpl @Inject constructor(
    private val socialHelpApi: SocialHelpApi
) : SpecializationsRepository {

    override suspend fun findAllSpecializations(): List<SpecializationItem> =
        socialHelpApi.getAllSpecializations().map {
            SpecializationItem(
                it.id,
                it.specialization
            )
        }
}