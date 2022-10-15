package com.ebi_tarou.shinysupporter.infra.repository.impl

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauMasterDao
import com.ebi_tarou.shinysupporter.infra.db.entity.NouhauMasterEntity
import com.ebi_tarou.shinysupporter.infra.repository.NouhauMasterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NouhauMasterRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val nouhauMasterDao: NouhauMasterDao
) : NouhauMasterRepository {

    override suspend fun getAll(): List<Nouhau> = withContext(dispatcher) {
        nouhauMasterDao.getAll().map { nouhauMasterEntity ->
            mapToModel(nouhauMasterEntity)
        }
    }

    private fun mapToModel(nouhauMasterEntity: NouhauMasterEntity) = Nouhau(
        id = nouhauMasterEntity.id,
        name = nouhauMasterEntity.name,
        caption = nouhauMasterEntity.caption,
        canTakeOver = nouhauMasterEntity.canTakeOver,
        dropArea = nouhauMasterEntity.dropArea,
        dropConditionCaption = nouhauMasterEntity.dropConditionCaption
    )
}