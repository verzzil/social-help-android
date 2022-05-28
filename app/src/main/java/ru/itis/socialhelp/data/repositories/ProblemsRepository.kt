package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.ProblemItem

interface ProblemsRepository {

    suspend fun findAllProblems(): List<ProblemItem>
}