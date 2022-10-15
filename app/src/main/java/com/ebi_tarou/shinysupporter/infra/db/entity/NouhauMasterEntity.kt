package com.ebi_tarou.shinysupporter.infra.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "nouhau_master_table")
data class NouhauMasterEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "caption")
    val caption: String,
    @ColumnInfo(name = "can_take_over")
    val canTakeOver: Boolean,
    @ColumnInfo(name = "drop_area")
    val dropArea: String,
    @ColumnInfo(name = "drop_condition_caption")
    val dropConditionCaption: String,
    @ColumnInfo(name = "create_at")
    val createAt: LocalDateTime
)