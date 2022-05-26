package ru.itis.socialhelp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.socialhelp.data.db.dao.TimeTableDao
import ru.itis.socialhelp.data.db.models.TimeTableDb

const val DB_NAME = "social_help.db"

@Database(
    entities = [TimeTableDb::class],
    version = 1,
    exportSchema = false
)
abstract class SocialHelpDb: RoomDatabase() {
    abstract fun getTimeTableDao(): TimeTableDao
}