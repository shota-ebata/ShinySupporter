package com.ebi_tarou.shinysupporter.di.module

import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherDefault
import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherIO
import com.ebi_tarou.shinysupporter.di.annotation.CoroutineDispatcherMain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CoroutineDispatcherModule {

    @CoroutineDispatcherIO
    @Provides
    fun provideDispatchersIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @CoroutineDispatcherDefault
    @Provides
    fun provideDispatchersDefault(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @CoroutineDispatcherMain
    @Provides
    fun provideDispatchersMain(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}