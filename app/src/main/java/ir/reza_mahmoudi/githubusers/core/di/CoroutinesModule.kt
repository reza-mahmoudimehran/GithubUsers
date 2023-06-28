package ir.reza_mahmoudi.githubusers.core.di

import dagger.Module
import dagger.Provides
import ir.reza_mahmoudi.githubusers.core.di.qualifiers.DefaultDispatcher
import ir.reza_mahmoudi.githubusers.core.di.qualifiers.IoDispatcher
import ir.reza_mahmoudi.githubusers.core.di.qualifiers.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoroutinesModule {

    @Provides
    @DefaultDispatcher
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
