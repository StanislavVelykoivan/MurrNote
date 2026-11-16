package com.stanislavvelykoivan.murrnote.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.stanislavvelykoivan.murrnote.note.database.NoteDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<NoteDatabase> {
        val dbFile = documentDirectory() + "/" + NoteDatabase.DB_NAME
        return Room.databaseBuilder<NoteDatabase>(name = dbFile)
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory(): String {
        val directory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(directory?.path)
    }
}
