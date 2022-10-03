package com.geektech.notesapi.domain.usecase

import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUsecase @Inject constructor(
    private val noteRepository: NoteRepository
    ) {

    fun createNotes(note: Note)=noteRepository.createNote(note)
}