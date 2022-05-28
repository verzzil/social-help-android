package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.repositories.SpecialistsRepository
import ru.itis.socialhelp.features.main.models.SpecializationItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.itis.socialhelp.features.main.models.testCategoryList
import ru.itis.socialhelp.features.specialists.models.SpecialistItem
import ru.itis.socialhelp.features.specialists.models.testSpecialistList
import javax.inject.Inject

class SpecialistsRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : SpecialistsRepository {

    override fun findMySpecialists(userId: Long): Flow<List<SpecializationItem>> {
        return flow {
            delay(10000)
            emit(testCategoryList)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun findAllSpecialists(): List<SpecializationItem> {
        delay(5000)
        return testCategoryList
    }

    override suspend fun findSpecialistsByCategoryId(id: Long): List<SpecialistItem> =
        socialHelpApi.getSpecialistsBySpecializationId(id).map {
            SpecialistItem(
                it.id,
                name = it.firstName,
                lastName = it.lastName,
                patronymic = "",
                image = /*it.avatarUrl*/ "",
                age = 0,
                experience = it.experience,
            )
        }
}