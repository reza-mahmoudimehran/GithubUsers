package ir.reza_mahmoudi.githubusers.feature_search.di

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import ir.reza_mahmoudi.githubusers.feature_search.data.FakeSearchRepository
import ir.reza_mahmoudi.githubusers.feature_search.domain.SearchRepository
import javax.inject.Singleton


@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SearchModule::class]
)
@Module
interface FakeSearchModule {

    @Singleton
    @Binds
    fun bindsSearchRepository(fakeSearchRepository: FakeSearchRepository) : SearchRepository
}