package com.ebi_tarou.shinysupporter.infra.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ebi_tarou.shinysupporter.infra.db.entity.ObtainedNouhauEntity

@Dao
interface ObtainedNouhauDao {
    @Query("SELECT * FROM obtained_nouhau_table")
    suspend fun getAll(): List<ObtainedNouhauEntity>

    @Query("SELECT * FROM obtained_nouhau_table WHERE nouhau_note_id = :nouhauNoteId")
    suspend fun getByNouhauNoteId(nouhauNoteId: Int): List<ObtainedNouhauEntity>

    @Insert
    suspend fun insert(vararg obtainedNouhauEntity: ObtainedNouhauEntity)

    @Delete
    suspend fun delete(obtainedNouhauEntity: ObtainedNouhauEntity)
}