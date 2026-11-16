package com.stanislavvelykoivan.murrnote.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.stanislavvelykoivan.murrnote.database.DatabaseFactory
import com.stanislavvelykoivan.murrnote.note.database.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
    single { get<NoteDatabase>().noteDao }
}
