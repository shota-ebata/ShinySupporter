package com.ebi_tarou.shinysupporter.infra.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauMasterEntity

@Dao
interface NouhauMasterDao {
    @Query("SELECT * FROM nouhau_master_table")
    suspend fun getAll(): List<NouhauMasterEntity>

    @Insert
    suspend fun insert(vararg nouhauMasterList: NouhauMasterEntity)

    @Delete
    suspend fun delete(nouhauMaster: NouhauMasterEntity)
}