package ru.itis.socialhelp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.itis.socialhelp.data.repositories.*
import ru.itis.socialhelp.data.repositories.impl.*

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun bindSpecialistsRepository(repo: SpecialistsRepositoryImpl): SpecialistsRepository

    @Binds
    abstract fun bindSpecializationsRepository(repo: ProblemsRepositoryImpl): ProblemsRepository

    @Binds
    abstract fun bindCategoriesRepository(repo: SpecializationsRepositoryImpl): SpecializationsRepository

    @Binds
    abstract fun bindDataStorePreferencesRepository(repo: DataStorePreferencesRepositoryImpl): DataStorePreferencesRepository

    @Binds
    abstract fun bindLoginRepositoryImpl(repo: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun bindProfileRepositoryImpl(repo: ProfileRepositoryImpl): ProfileRepository
}