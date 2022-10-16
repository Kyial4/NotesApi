package com.geektech.notesapi.domain.repository

import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.utills.Resource
import dagger.Component
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note):Flow<Resource<Unit>>

    fun editNote(note:Note):Flow <Resource<Unit>>

    fun deleteNote(note:Note):Flow <Resource<Unit>>

    fun getAllNotes():Flow <Resource<List<Note>>>
}