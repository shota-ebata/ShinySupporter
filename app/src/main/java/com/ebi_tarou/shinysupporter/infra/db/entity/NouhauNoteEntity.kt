package com.ebi_tarou.shinysupporter.infra.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ebi_tarou.shinysupporter.domain.constant.Idol
import java.time.LocalDateTime

@Entity(tableName = "nouhau_note_table")
data class NouhauNoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "idol")
    val idol: Idol,
    @ColumnInfo(name = "drop_date_time")
    val dropDateTime: LocalDateTime,
    @ColumnInfo(name = "create_at")
    val createAt: LocalDateTime
)