package com.ebi_tarou.shinysupporter.infra.repository

import com.ebi_tarou.shinysupporter.domain.model.ObtainedNouhau

interface ObtainedNouhauRepository {
    suspend fun getListByNouhauNoteId(nouhauNoteId: Int): List<ObtainedNouhau>
}