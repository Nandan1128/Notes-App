package com.example.notesapp.Repository

import androidx.lifecycle.LiveData
import com.example.notesapp.Model.Notes
import com.example.notesapp.NotesDao.NotesDao

class NotesRepository(val dao : NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>>{
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }
    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }
    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}