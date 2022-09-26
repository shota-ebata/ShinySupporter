package com.ebi_tarou.shinysupporter.infra.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauNoteEntity

@Database(
    entities = [
        NouhauNoteEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nouhauNoteDao(): NouhauNoteDao
}