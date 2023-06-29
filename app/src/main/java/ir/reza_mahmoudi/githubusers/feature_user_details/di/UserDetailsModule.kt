package ir.reza_mahmoudi.githubusers.feature_user_details.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.reza_mahmoudi.githubusers.feature_user_details.data.UserDetailsRepositoryImpl
import ir.reza_mahmoudi.githubusers.feature_user_details.data.remote.UserDetailsRemoteDataSource
import ir.reza_mahmoudi.githubusers.feature_user_details.data.remote.UserDetailsRemoteDataSourceImpl
import ir.reza_mahmoudi.githubusers.feature_user_details.domain.UserDetailsRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface UserDetailsModule {

    @Singleton
    @Binds
    fun bindsUserDetailsRepository(userDetailsRepositoryImpl: UserDetailsRepositoryImpl) : UserDetailsRepository

    @Singleton
    @Binds
    fun bindsUserDetailsRemoteDataSource(userDetailsRemoteDataSourceImpl: UserDetailsRemoteDataSourceImpl) : UserDetailsRemoteDataSource
}