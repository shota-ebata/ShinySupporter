package com.ebi_tarou.shinysupporter.infra.repository

import com.ebi_tarou.shinysupporter.domain.model.Nouhau

interface NouhauMasterRepository {
    suspend fun getAll(): List<Nouhau>
}