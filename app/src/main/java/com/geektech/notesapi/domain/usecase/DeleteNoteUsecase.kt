package com.geektech.notesapi.domain.usecase

import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUsecase@Inject constructor(
    private val noteRepository: NoteRepository
    ) {

    fun deleteNotes(note: Note)=noteRepository.deleteNote(note)
}