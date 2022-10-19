package com.ebi_tarou.shinysupporter.di.module

import android.app.Application
import androidx.room.Room
import com.ebi_tarou.shinysupporter.infra.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java, "database"
        ).build()
    }
}