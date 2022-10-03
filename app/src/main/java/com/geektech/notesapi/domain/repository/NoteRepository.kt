package com.geektech.notesapi.domain.repository

import com.geektech.notesapi.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note):Flow <Unit>

    fun editNote(note:Note):Flow <Unit>

    fun deleteNote(note:Note):Flow <Unit>

    fun getAllNotes():Flow <List<Note>>
}