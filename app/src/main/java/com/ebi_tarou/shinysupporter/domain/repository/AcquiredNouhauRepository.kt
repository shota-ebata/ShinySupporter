package com.ebi_tarou.shinysupporter.domain.repository

import com.ebi_tarou.shinysupporter.domain.model.AcquiredNouhau

interface AcquiredNouhauRepository {
    suspend fun getListByNouhauNoteId(nouhauNoteId: Int): List<AcquiredNouhau>
}