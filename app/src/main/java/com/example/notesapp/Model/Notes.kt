package com.example.notesapp.Model

import androidx.compose.foundation.MutatePriority
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
class Notes (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var title : String,
    var subtitle : String,
    var note : String,
    var date : String,
    var priority: String
)
