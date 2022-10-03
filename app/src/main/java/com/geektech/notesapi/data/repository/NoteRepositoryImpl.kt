package com.geektech.notesapi.data.repository

import com.geektech.notesapi.App
import com.geektech.notesapi.data.localdb.NoteDao
import com.geektech.notesapi.data.mapper.noteEntityToNote
import com.geektech.notesapi.data.mapper.noteToNoteEntity
import com.geektech.notesapi.data.model.NoteEntity
import com.geektech.notesapi.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl@Inject constructor(private val noteDao: NoteDao):
    com.geektech.notesapi.domain.repository.NoteRepository {

    override fun createNote(note: Note) :Flow<Unit>{
        return flow {
            noteDao.createNote(note.noteToNoteEntity())
        }

    }

    override fun editNote(note: Note):Flow<Unit> {
        return flow {
            noteDao.editNote(note.noteToNoteEntity())
        }
    }

    override fun deleteNote(note: Note):Flow<Unit> {
        return flow {
            noteDao.deleteNote(note.noteToNoteEntity())
        }

    }

    override fun getAllNotes() :Flow<List<Note>>{
        return flow {
            noteDao.getAllNotes().map{it.noteEntityToNote()   }
        }


    }

}