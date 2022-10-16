package com.geektech.notesapi.data.repository

import com.geektech.notesapi.App
import com.geektech.notesapi.data.localdb.NoteDao
import com.geektech.notesapi.data.mapper.noteEntityToNote
import com.geektech.notesapi.data.mapper.noteToNoteEntity
import com.geektech.notesapi.data.model.NoteEntity
import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.repository.NoteRepository
import com.geektech.notesapi.domain.utills.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl@Inject constructor(private val noteDao: NoteDao):
    com.geektech.notesapi.domain.repository.NoteRepository {

    override fun createNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try{
        val data= noteDao.createNote(note.noteToNoteEntity())
            emit(Resource.Success(data))
    }catch (e:Exception){
    emit(Resource.Error(e.localizedMessage))}
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> = flow {
        noteDao.editNote(note.noteToNoteEntity())
    }


    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
        noteDao.deleteNote(note.noteToNoteEntity())
    }


    override fun getAllNotes(): Flow<Resource<List<Note>>> = flow {
        noteDao.getAllNotes().map { it.noteEntityToNote() }
    }
}