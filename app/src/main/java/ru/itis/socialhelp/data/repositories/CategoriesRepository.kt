package ru.itis.socialhelp.data.repositories

import ru.itis.socialhelp.features.main.models.CategoryItem

interface CategoriesRepository {

    suspend fun findAllCategories(): List<CategoryItem>
}