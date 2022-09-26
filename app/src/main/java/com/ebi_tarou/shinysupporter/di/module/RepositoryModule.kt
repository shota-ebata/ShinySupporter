package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepository
import com.ebi_tarou.shinysupporter.infra.repository.impl.NouhauNoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNouhauNoteRepository(nouhauNoteRepositoryImpl: NouhauNoteRepositoryImpl): NouhauNoteRepository
}