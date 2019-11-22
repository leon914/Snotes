package com.example.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.models.Note
import com.example.repository.database.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteentity")
    fun getAll(): List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<NoteEntity>
    
    
//      query example
//    @Query(
//        "SELECT * FROM user WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String, last: String): Note

    @Insert
    fun insert(note: NoteEntity)

    @Insert
    fun insertAll(notes: List<NoteEntity>)

    @Delete
    fun delete(note: NoteEntity)
}

