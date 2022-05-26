package ru.itis.socialhelp.data.repositories.impl

import ru.itis.socialhelp.data.network.SocialHelpApi
import ru.itis.socialhelp.data.repositories.CategoriesRepository
import ru.itis.socialhelp.features.main.models.CategoryItem
import ru.itis.socialhelp.features.main.models.testCategoryList
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val socialHelpApi: SocialHelpApi
) : CategoriesRepository {

    override suspend fun findAllCategories(): List<CategoryItem> =
        testCategoryList
}