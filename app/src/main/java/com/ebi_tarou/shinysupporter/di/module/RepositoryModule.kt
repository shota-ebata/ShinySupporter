package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.infra.repository.NouhauMasterRepository
import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepository
import com.ebi_tarou.shinysupporter.infra.repository.ObtainedNouhauRepository
import com.ebi_tarou.shinysupporter.infra.repository.impl.NouhauMasterRepositoryImpl
import com.ebi_tarou.shinysupporter.infra.repository.impl.NouhauNoteRepositoryImpl
import com.ebi_tarou.shinysupporter.infra.repository.impl.ObtainedNouhauRepositoryImpl
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
    abstract fun bindObtainedNouhauRepository(obtainedNouhauRepositoryImpl: ObtainedNouhauRepositoryImpl): ObtainedNouhauRepository
}