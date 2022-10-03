package com.geektech.notesapi.domain.usecase

import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUsecase@Inject constructor(
    private val noteRepository: NoteRepository
    ) {

    fun editNotes(note: Note)=noteRepository.editNote(note)
}