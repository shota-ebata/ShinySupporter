package com.ebi_tarou.shinysupporter.infra.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "obtained_nouhau_table")
data class ObtainedNouhauEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "nouhau_note_id")
    val nouhauNoteId: Int,
    @ColumnInfo(name = "nouhau_master_id")
    val nouhauMasterId: Int,
    @ColumnInfo(name = "level")
    val level: Int?
)