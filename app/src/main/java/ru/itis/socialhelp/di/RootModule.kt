package ru.itis.socialhelp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(ViewModelComponent::class)
@Module
object RootModule {

    @ViewModelScoped
    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.Default
}