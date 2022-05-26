package ru.itis.socialhelp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.itis.socialhelp.data.repositories.CategoriesRepository
import ru.itis.socialhelp.data.repositories.SpecialistsRepository
import ru.itis.socialhelp.data.repositories.SpecializationsRepository
import ru.itis.socialhelp.data.repositories.impl.CategoriesRepositoryImpl
import ru.itis.socialhelp.data.repositories.impl.SpecialistsRepositoryImpl
import ru.itis.socialhelp.data.repositories.impl.SpecializationsRepositoryImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun bindSpecialistsRepository(repo: SpecialistsRepositoryImpl): SpecialistsRepository

    @Binds
    abstract fun bindSpecializationsRepository(repo: SpecializationsRepositoryImpl): SpecializationsRepository

    @Binds
    abstract fun bindCategoriesRepository(repo: CategoriesRepositoryImpl): CategoriesRepository
}