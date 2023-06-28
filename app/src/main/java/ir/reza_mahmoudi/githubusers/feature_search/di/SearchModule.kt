package ir.reza_mahmoudi.githubusers.feature_search.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.reza_mahmoudi.githubusers.feature_search.data.SearchRepositoryImpl
import ir.reza_mahmoudi.githubusers.feature_search.data.remote.SearchRemoteDataSource
import ir.reza_mahmoudi.githubusers.feature_search.data.remote.SearchRemoteDataSourceImpl
import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface SearchModule {

    @Singleton
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository

    @Singleton
    @Binds
    fun bindsSearchRemoteDataSource(searchRemoteDataSourceImpl: SearchRemoteDataSourceImpl) : SearchRemoteDataSource
}