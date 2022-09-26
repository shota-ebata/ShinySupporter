package com.ebi_tarou.shinysupporter.infra.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauNoteEntity

@Dao
interface NouhauNoteDao {
    @Query("SELECT * FROM nouhau_note_table")
    suspend fun getAll(): List<NouhauNoteEntity>

    @Insert
    suspend fun insert(vararg nouhauNoteList: NouhauNoteEntity)

    @Delete
    suspend fun delete(nouhauNote: NouhauNoteEntity)
}