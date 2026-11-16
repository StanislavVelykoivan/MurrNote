package com.stanislavvelykoivan.murrnote

import android.app.Application
import com.stanislavvelykoivan.murrnote.di.initKoin
import org.koin.android.ext.koin.androidContext

class MurrNoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MurrNoteApp)
        }
    }
}
