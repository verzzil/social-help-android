package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.features.main.models.SpecializationItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.itis.socialhelp.features.main.models.testSpecializationList
import javax.inject.Inject

class SpecializationsRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : SpecializationsRepository {

    override fun findAllProblems(): Flow<List<SpecializationItem>> {
        return flow {
            delay(3000)
            emit(testSpecializationList)
        }.flowOn(Dispatchers.IO)
    }
}
