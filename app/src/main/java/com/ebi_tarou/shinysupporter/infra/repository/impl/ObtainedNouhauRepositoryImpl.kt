package com.ebi_tarou.shinysupporter.infra.repository.impl

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.domain.model.ObtainedNouhau
import com.ebi_tarou.shinysupporter.infra.db.dao.ObtainedNouhauDao
import com.ebi_tarou.shinysupporter.infra.db.entity.ObtainedNouhauEntity
import com.ebi_tarou.shinysupporter.infra.repository.NouhauMasterRepository
import com.ebi_tarou.shinysupporter.infra.repository.ObtainedNouhauRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ObtainedNouhauRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val nouhauMasterRepository: NouhauMasterRepository,
    private val obtainedNouhauDao: ObtainedNouhauDao
) : ObtainedNouhauRepository {

    override suspend fun getListByNouhauNoteId(nouhauNoteId: Int): List<ObtainedNouhau> = withContext(dispatcher) {
        val nouhauMasterList = nouhauMasterRepository.getAll()
        obtainedNouhauDao.getByNouhauNoteId(nouhauNoteId).map { obtainedNouhauEntity ->
            mapToModel(obtainedNouhauEntity, nouhauMasterList)
        }
    }

    private fun mapToModel(obtainedNouhauEntity: ObtainedNouhauEntity, nouhauMasterList: List<Nouhau>) = ObtainedNouhau(
        id = obtainedNouhauEntity.id,
        nouhauNoteId = obtainedNouhauEntity.nouhauNoteId,
        nouhau = nouhauMasterList.find { it.id == obtainedNouhauEntity.nouhauMasterId }!!,
        level = obtainedNouhauEntity.level
    )
}