package com.android.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao //Data Access Object
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes_table order by id ASC")
    fun getAllNote() : LiveData<List<Note>>
}