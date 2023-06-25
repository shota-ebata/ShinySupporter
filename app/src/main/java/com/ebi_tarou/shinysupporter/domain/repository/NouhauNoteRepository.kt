package com.ebi_tarou.shinysupporter.domain.repository

import com.ebi_tarou.shinysupporter.domain.model.NouhauNote

interface NouhauNoteRepository {

    suspend fun getAll(): List<NouhauNote>
}