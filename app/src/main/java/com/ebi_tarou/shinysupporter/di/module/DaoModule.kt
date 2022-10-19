package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.infra.db.AppDatabase
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauMasterDao
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.db.dao.ObtainedNouhauDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideNouhauMasterDao(appDatabase: AppDatabase): NouhauMasterDao {
        return appDatabase.nouhauMasterDao()
    }

    @Provides
    @Singleton
    fun provideNouhauNoteDao(appDatabase: AppDatabase): NouhauNoteDao {
        return appDatabase.nouhauNoteDao()
    }

    @Provides
    @Singleton
    fun provideObtainedNouhauDao(appDatabase: AppDatabase): ObtainedNouhauDao {
        return appDatabase.obtainedNouhauDao()
    }
}