package com.geektech.notesapi

import android.app.Application
import androidx.room.Room
import com.geektech.notesapi.data.localdb.NoteDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object{
        lateinit var roomNoteDatabase:NoteDatabase
    }


    override fun onCreate() {
        super.onCreate()
        roomNoteDatabase= Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "note_db"
        ).allowMainThreadQueries().build()

    }
}