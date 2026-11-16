package com.stanislavvelykoivan.murrnote.note.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [NoteEntity::class], version = 1)
@ConstructedBy(NoteDatabaseConstructor::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DB_NAME = "murrnote.db"
    }
}

@Suppress("KotlinNoActualForExpect")
expect object NoteDatabaseConstructor : RoomDatabaseConstructor<NoteDatabase> {
    override fun initialize(): NoteDatabase
}
