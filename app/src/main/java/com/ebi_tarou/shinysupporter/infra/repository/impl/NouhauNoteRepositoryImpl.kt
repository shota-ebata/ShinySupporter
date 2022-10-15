package com.ebi_tarou.shinysupporter.infra.repository.impl

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.NouhauNote
import com.ebi_tarou.shinysupporter.domain.model.ObtainedNouhau
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauNoteEntity
import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepository
import com.ebi_tarou.shinysupporter.infra.repository.ObtainedNouhauRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NouhauNoteRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val obtainedNoteRepository: ObtainedNouhauRepository,
    private val nouhauNoteDao: NouhauNoteDao
) : NouhauNoteRepository {

    override suspend fun getAll(): List<NouhauNote> = withContext(dispatcher) {
        nouhauNoteDao.getAll().map { nouhauNoteEntity ->
            val obtainedNouhauList = obtainedNoteRepository.getListByNouhauNoteId(nouhauNoteEntity.id)
            mapToModel(nouhauNoteEntity, obtainedNouhauList)
        }
    }

    private fun mapToModel(nouhauNoteEntity: NouhauNoteEntity, obtainedNouhauList: List<ObtainedNouhau>) = NouhauNote(
        id = nouhauNoteEntity.id,
        idol = nouhauNoteEntity.idol,
        obtainedNouhauList = obtainedNouhauList,
        dropDateTime = nouhauNoteEntity.dropDateTime
    )
}