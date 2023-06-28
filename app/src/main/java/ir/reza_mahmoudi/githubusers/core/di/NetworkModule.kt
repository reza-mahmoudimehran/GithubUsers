package ir.reza_mahmoudi.githubusers.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.reza_mahmoudi.githubusers.BuildConfig
import ir.reza_mahmoudi.githubusers.core.data.local.GithubApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, 10 * 10 * 1024)


    @Singleton
    @Provides
    fun providesOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient
        .Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .cache(cache)
        .build()


    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()


    @Singleton
    @Provides
    fun providesGithubApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)
}