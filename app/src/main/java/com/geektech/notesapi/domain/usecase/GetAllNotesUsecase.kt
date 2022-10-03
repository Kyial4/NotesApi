package com.geektech.notesapi.domain.usecase

import com.geektech.notesapi.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUsecase @Inject constructor(
    private val noteRepository: NoteRepository
    ) {

    fun getAllNotes()=noteRepository.getAllNotes()
}