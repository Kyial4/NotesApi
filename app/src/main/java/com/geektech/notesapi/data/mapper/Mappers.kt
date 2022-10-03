package com.geektech.notesapi.data.mapper

import com.geektech.notesapi.data.model.NoteEntity
import com.geektech.notesapi.domain.model.Note

fun Note.noteToNoteEntity()=NoteEntity(
    id=id,
    tittle=tittle,
    text=text
)

fun NoteEntity.noteEntityToNote()=Note(
    id=id,
    tittle=tittle,
    text=text
)