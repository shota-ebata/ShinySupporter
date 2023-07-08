package com.ebi_tarou.shinysupporter.infra.repository

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.AtamaNouhau
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauMasterDao
import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NouhauMasterRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val nouhauMasterDao: NouhauMasterDao
) : NouhauMasterRepository {

    private var count: Long = 0
    private fun countNext(): Long {
        count++
        return count
    }
    private val atamaList = listOf(
        AtamaNouhau(id = countNext(), name = "VocalUP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VocalUP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VocalUP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VocalUP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "DanceUP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "DanceUP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "DanceUP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "DanceUP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VisualUP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VisualUP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VisualUP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "VisualUP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタルUP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタルUP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタルUP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタルUP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Vocal上限UP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Vocal上限UP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Vocal上限UP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Vocal上限UP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Dance上限UP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Dance上限UP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Dance上限UP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Dance上限UP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Visual上限UP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Visual上限UP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Visual上限UP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "Visual上限UP+++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタル上限UP", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタル上限UP+", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタル上限UP++", caption = "", minLevel = 1, maxLevel = 5),
        AtamaNouhau(id = countNext(), name = "メンタル上限UP+++", caption = "", minLevel = 1, maxLevel = 5),
    )

    override suspend fun getAll(): List<Nouhau> = withContext(dispatcher) {
        nouhauMasterDao.getAll()
        // TODO: DBから取得できるようにする
        atamaList
    }

    override suspend fun getAllNouhaus(): Flow<List<Nouhau>> {
        return MutableStateFlow(atamaList)
    }

    override suspend fun getNouhau(id: Long): Nouhau? {
        return atamaList.find { it.id == id }
    }

}