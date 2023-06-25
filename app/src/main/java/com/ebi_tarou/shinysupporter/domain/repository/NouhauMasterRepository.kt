package com.ebi_tarou.shinysupporter.domain.repository

import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import kotlinx.coroutines.flow.Flow


interface NouhauMasterRepository {
    suspend fun getAll(): List<Nouhau>
    suspend fun getAllNouhaus(): Flow<List<Nouhau>>
}