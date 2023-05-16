package com.lnight.beerpaging3project.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.lnight.beerpaging3project.data.local.BeerDatabase
import com.lnight.beerpaging3project.data.local.BeerEntity
import com.lnight.beerpaging3project.data.remote.BeerApi
import com.lnight.beerpaging3project.data.remote.BeerRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@OptIn(ExperimentalPagingApi::class)
object AppModule {

    @Provides
    @Suppress
    fun provideBeerDatabase(
        @ApplicationContext context: Context
    ): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            BeerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .callTimeout(
                timeout = 5000L,
                unit = TimeUnit.MILLISECONDS
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(
        okHttpClient: OkHttpClient
    ): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideBeerPager(
        beerDb: BeerDatabase,
        beerApi: BeerApi
    ): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = BeerRemoteMediator(
                beerDb = beerDb,
                beerApi = beerApi
            ),
            pagingSourceFactory = {
                beerDb.dao.pagingSource()
            }
        )
    }
}