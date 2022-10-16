package com.geektech.notesapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val tittle:String,
    val text:String

): Serializable {
    constructor():this(0,"","")
}