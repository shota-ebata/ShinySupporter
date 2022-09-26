package com.ebi_tarou.shinysupporter.infra.repository.impl

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.domain.model.NouhauNote
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NouhauNoteRepositoryImpl
@Inject
constructor(
    @CoroutineDispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val dao: NouhauNoteDao
) : NouhauNoteRepository {

    override suspend fun getAll(): List<NouhauNote> = withContext(dispatcher) {
        dao.getAll().map {
            NouhauNote(
                id = it.id,
                idol = it.idol
            )
        }
    }
}