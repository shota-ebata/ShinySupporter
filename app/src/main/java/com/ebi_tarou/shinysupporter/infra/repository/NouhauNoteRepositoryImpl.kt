package com.ebi_tarou.shinysupporter.infra.repository

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.NouhauNote
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.domain.repository.AcquiredNouhauRepository
import com.ebi_tarou.shinysupporter.domain.repository.NouhauNoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NouhauNoteRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val obtainedNoteRepository: AcquiredNouhauRepository,
    private val nouhauNoteDao: NouhauNoteDao
) : NouhauNoteRepository {

    override suspend fun getAll(): List<NouhauNote> = withContext(dispatcher) {
        // TODO: DBから取得できるようにする
        emptyList()
    }

}