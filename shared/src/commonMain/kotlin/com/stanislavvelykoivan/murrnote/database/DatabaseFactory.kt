package com.stanislavvelykoivan.murrnote.database

import androidx.room.RoomDatabase
import com.stanislavvelykoivan.murrnote.note.database.NoteDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<NoteDatabase>
}
