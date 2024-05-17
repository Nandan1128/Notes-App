package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.Model.Notes
import com.example.notesapp.NotesDatabase.NotesDatabase
import com.example.notesapp.Repository.NotesRepository

class NotesViewModal(application: Application) : AndroidViewModel(application) {

    private val repository: NotesRepository
    private val allNotes: LiveData<List<Notes>>

    init {
        val notesDao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(notesDao)
        allNotes = repository.getAllNotes()
    }

    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }
}
