package com.example.repository

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.models.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val db = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java, "database-name"
        ).build()

        noteDao = db.noteDao()
    }

    fun put(note: Note) {

    }

    fun getAll() = noteDao.getAll().map { Note(it.text) }
}
