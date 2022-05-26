package ru.itis.socialhelp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.itis.socialhelp.data.db.DB_NAME
import ru.itis.socialhelp.data.db.SocialHelpDb
import ru.itis.socialhelp.data.db.dao.TimeTableDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context) : SocialHelpDb =
        Room.databaseBuilder(
            context,
            SocialHelpDb::class.java,
            DB_NAME
        ).build()

    @Provides
    fun provideTimeTableDao(db: SocialHelpDb): TimeTableDao =
        db.getTimeTableDao()
}
