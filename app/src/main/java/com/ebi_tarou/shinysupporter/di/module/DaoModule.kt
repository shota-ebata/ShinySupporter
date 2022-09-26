package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.infra.db.AppDatabase
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauMasterDao
import com.ebi_tarou.shinysupporter.infra.db.dao.NouhauNoteDao
import com.ebi_tarou.shinysupporter.infra.db.dao.ObtainedNouhauDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    fun provideNouhauMasterDao(appDatabase: AppDatabase): NouhauMasterDao {
        return appDatabase.nouhauMasterDao()
    }

    @Provides
    fun provideNouhauNoteDao(appDatabase: AppDatabase): NouhauNoteDao {
        return appDatabase.nouhauNoteDao()
    }

    @Provides
    fun provideObtainedNouhauDao(appDatabase: AppDatabase): ObtainedNouhauDao {
        return appDatabase.obtainedNouhauDao()
    }
}