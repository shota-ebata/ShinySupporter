package com.ebi_tarou.shinysupporter.infra.repository

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.AcquiredNouhau
import com.ebi_tarou.shinysupporter.infra.db.dao.ObtainedNouhauDao
import com.ebi_tarou.shinysupporter.domain.repository.AcquiredNouhauRepository
import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AcquiredNouhauRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val nouhauMasterRepository: NouhauMasterRepository,
    private val obtainedNouhauDao: ObtainedNouhauDao
) : AcquiredNouhauRepository {

    override suspend fun getListByNouhauNoteId(nouhauNoteId: Int): List<AcquiredNouhau> = withContext(dispatcher) {
        val nouhauMasterList = nouhauMasterRepository.getAll()
        // TODO: DBから取得できるようにする
        emptyList()
    }

}