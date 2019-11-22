package com.example.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.repository.database.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}