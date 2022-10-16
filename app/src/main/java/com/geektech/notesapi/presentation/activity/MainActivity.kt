package com.geektech.notesapi.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geektech.notesapi.R
import com.geektech.notesapi.databinding.ActivityMainBinding
import com.geektech.notesapi.domain.model.Note
import com.geektech.notesapi.presentation.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllNotes()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllNotesState.collect{
                    when(it){
                        is UIState.Loading ->{
                            binding.progress.isVisible=true
                        }
                        is UIState.Error ->{
                            Toast.makeText(this@MainActivity,it.error, Toast.LENGTH_SHORT).show()
                            binding.progress.isVisible=false
                        }
                        is UIState.Success ->{
                            binding.tvNotes.text=it.data.toString()
                            binding.progress.isVisible=false
                        }
                    }
            }

            }
        }
        var i=0
        binding.btnAddNote.setOnClickListener{
            i++
        viewModel.createNote(Note(tittle=i.toString(), text= i.toString()))
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.createNoteState.collect{
                    when(it){
                        is UIState.Loading ->{
                        }
                        is UIState.Error ->{
                            Toast.makeText(this@MainActivity,it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success ->{
                            viewModel.getAllNotes()
                        }
                    }
                }

            }
        }
        binding.btnAddNote.setOnClickListener{
            i++
            viewModel.editNote(Note(tittle=i.toString(), text= i.toString()))
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.editNoteState.collect{
                    when(it){
                        is UIState.Loading ->{
                        }
                        is UIState.Error ->{
                            Toast.makeText(this@MainActivity,it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success ->{
                            viewModel.getAllNotes()
                        }
                    }
                }

            }
        }
        binding.btnAddNote.setOnClickListener{
            i++
            viewModel.deleteNote(Note(tittle=i.toString(), text= i.toString()))
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.deleteNoteState.collect{
                    when(it){
                        is UIState.Loading ->{
                        }
                        is UIState.Error ->{
                            Toast.makeText(this@MainActivity,it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success ->{
                            viewModel.getAllNotes()
                        }
                    }
                }

            }
        }
    }
}