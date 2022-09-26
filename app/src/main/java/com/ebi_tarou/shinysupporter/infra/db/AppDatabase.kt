package com.ebi_tarou.shinysupporter.infra.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauMasterDao
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.db.dao.ObtainedNouhauDao
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauMasterEntity
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauNoteEntity
import com.ebi_tarou.shinysupporter.infra.db.entity.ObtainedNouhauEntity

@Database(
    entities = [
        NouhauMasterEntity::class,
        NouhauNoteEntity::class,
        ObtainedNouhauEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    // Master
    abstract fun nouhauMasterDao(): NouhauMasterDao

    // Transaction
    abstract fun nouhauNoteDao(): NouhauNoteDao
    abstract fun obtainedNouhauDao(): ObtainedNouhauDao
}