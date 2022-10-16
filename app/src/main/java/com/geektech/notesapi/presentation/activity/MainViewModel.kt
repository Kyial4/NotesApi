package com.geektech.notesapi.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.domain.usecase.CreateNoteUsecase
import com.geektech.notesapi.domain.usecase.DeleteNoteUsecase
import com.geektech.notesapi.domain.usecase.EditNoteUsecase
import com.geektech.notesapi.domain.usecase.GetAllNotesUsecase
import com.geektech.notesapi.domain.utills.Resource
import com.geektech.notesapi.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val gettAllNotesUsecase: GetAllNotesUsecase,
    private val createNoteUsecase: CreateNoteUsecase,
    private val editNoteUsecase: EditNoteUsecase,
    private val deleteNoteUsecase: DeleteNoteUsecase
) :ViewModel() {

    private val _getAllNotesState= MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesState=_getAllNotesState.asStateFlow()

    private val _editNoteState= MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val editNoteState=_editNoteState.asStateFlow()

    private val _createNoteState= MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val createNoteState=_createNoteState.asStateFlow()

    private val _deleteNoteState= MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteNoteState=_deleteNoteState.asStateFlow()

    fun getAllNotes(){
        viewModelScope.launch {
            gettAllNotesUsecase.getAllNotes().collect(){
                when(it){
                    is Resource.Loading ->{
                        _getAllNotesState.value=UIState.Loading()
                    }
                    is Resource.Error ->{
                        _getAllNotesState.value=UIState.Error(it.message?:"")
                    }
                    is Resource.Success ->{
                        if (it.data!=null)
                            _getAllNotesState.value= UIState.Success(it.data)

                    }
                }
            }
        }
    }
    fun createNote(note:Note){
        viewModelScope.launch {
            createNoteUsecase.createNotes(note).collect(){
                when(it){
                    is Resource.Loading ->{
                        _createNoteState.value=UIState.Loading()
                    }
                    is Resource.Error ->{
                        _createNoteState.value=UIState.Error(it.message?:"")
                    }
                    is Resource.Success ->{
                        if (it.data!=null)
                            _createNoteState.value= UIState.Success(it.data)

                    }
                }
            }
        }
    }
    fun editNote(note:Note){
        viewModelScope.launch {
            editNoteUsecase.editNotes(note).collect(){
                when(it){
                    is Resource.Loading ->{
                        _editNoteState.value=UIState.Loading()
                    }
                    is Resource.Error ->{
                        _editNoteState.value=UIState.Error(it.message?:"")
                    }
                    is Resource.Success ->{
                        if (it.data!=null)
                            _editNoteState.value= UIState.Success(it.data)

                    }
                }
            }
        }
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
            deleteNoteUsecase.deleteNotes(note).collect(){
                when(it){
                    is Resource.Loading ->{
                        _deleteNoteState.value=UIState.Loading()
                    }
                    is Resource.Error ->{
                        _deleteNoteState.value=UIState.Error(it.message?:"")
                    }
                    is Resource.Success ->{
                        if (it.data!=null)
                            _deleteNoteState.value= UIState.Success(it.data)

                    }
                }
            }
        }
    }
}