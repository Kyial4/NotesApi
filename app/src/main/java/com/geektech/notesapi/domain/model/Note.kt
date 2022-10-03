package com.geektech.notesapi.domain.model

data class Note (
    val id:Int=DEFAULT_ID,
    val tittle:String,
    val text:String

){
    companion object{
        const val DEFAULT_ID=0
    }
}