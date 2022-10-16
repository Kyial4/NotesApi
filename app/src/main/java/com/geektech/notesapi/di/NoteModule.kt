package com.geektech.notesapi.di

import android.content.Context
import androidx.room.Room
import com.geektech.notesapi.data.localdb.NoteDao
import com.geektech.notesapi.data.localdb.NoteDatabase
import com.geektech.notesapi.data.repository.NoteRepositoryImpl
import com.geektech.notesapi.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(
        @ApplicationContext context: Context
    ): NoteDatabase = Room.databaseBuilder(
        context, NoteDatabase::class.java, "note_db"
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()


    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)

}
