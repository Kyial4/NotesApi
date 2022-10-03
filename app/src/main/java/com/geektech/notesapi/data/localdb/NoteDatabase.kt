package com.geektech.notesapi.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.notesapi.data.model.NoteEntity

@Database(entities=[NoteEntity::class], version = 1)
abstract class NoteDatabase:RoomDatabase(){

    abstract fun noteDao():NoteDao
}