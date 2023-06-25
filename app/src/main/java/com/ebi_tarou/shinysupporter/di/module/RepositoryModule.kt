package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import com.ebi_tarou.shinysupporter.domain.repository.NouhauNoteRepository
import com.ebi_tarou.shinysupporter.domain.repository.AcquiredNouhauRepository
import com.ebi_tarou.shinysupporter.infra.repository.NouhauMasterRepositoryImpl
import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepositoryImpl
import com.ebi_tarou.shinysupporter.infra.repository.AcquiredNouhauRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNouhauNoteRepository(nouhauNoteRepositoryImpl: NouhauNoteRepositoryImpl): NouhauNoteRepository

    @Binds
    @Singleton
    abstract fun bindNouhauMasterRepository(nouhauMasterRepositoryImpl: NouhauMasterRepositoryImpl): NouhauMasterRepository

    @Binds
    @Singleton
    abstract fun bindObtainedNouhauRepository(obtainedNouhauRepositoryImpl: AcquiredNouhauRepositoryImpl): AcquiredNouhauRepository
}