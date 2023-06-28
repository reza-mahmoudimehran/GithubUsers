package ir.reza_mahmoudi.githubusers.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.reza_mahmoudi.githubusers.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesCache(@ApplicationContext context: Context) =
        Cache(context.cacheDir, 10 * 10 * 1024)


    @Singleton
    @Provides
    fun providesOkHttpClient(cache: Cache) = OkHttpClient
        .Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .cache(cache)
        .build()


    @Singleton
    @Provides
    fun providesMoshiConvertorFactory() = MoshiConverterFactory.create()


    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshiConvertorFactory: MoshiConverterFactory) =
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConvertorFactory)
            .build()
}