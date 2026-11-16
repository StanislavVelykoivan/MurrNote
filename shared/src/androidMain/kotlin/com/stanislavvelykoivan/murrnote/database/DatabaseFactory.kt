package com.stanislavvelykoivan.murrnote.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stanislavvelykoivan.murrnote.note.database.NoteDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<NoteDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(NoteDatabase.DB_NAME)
        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath,
        )
    }
}
