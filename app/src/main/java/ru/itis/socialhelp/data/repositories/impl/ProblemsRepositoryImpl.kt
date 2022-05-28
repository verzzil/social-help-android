package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.repositories.ProblemsRepository
import ru.itis.socialhelp.features.main.models.ProblemItem
import javax.inject.Inject

class ProblemsRepositoryImpl @Inject constructor(
    val socialHelpApi: SocialHelpApi
) : ProblemsRepository {

    override suspend fun findAllProblems(): List<ProblemItem> =
        socialHelpApi.getProblems().map {
            ProblemItem(
                it.id,
                /*it.photoUrl*/ "",
                it.problemDescription
            )
        }
}
